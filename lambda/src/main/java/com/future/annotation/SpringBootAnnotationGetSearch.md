# search

spring-boot annotation search algorithm

```java
@SpringBootApplication
@ImportResource("classpath:future.xml")
@MapperScan(basePackages = {"com.future.annotation.mapper"})
public class TradeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradeServiceApplication.class, args);
        com.alibaba.dubbo.container.Main.main(args);
    }

}
```

## step 1

```java
        /**
	 * Perform the search algorithm for the {@link #searchWithGetSemantics}
	 * method, avoiding endless recursion by tracking which annotated elements
	 * have already been <em>visited</em>.
	 * <p>The {@code metaDepth} parameter is explained in the
	 * {@link Processor#process process()} method of the {@link Processor} API.
	 * @param element the annotated element
	 * @param annotationType the annotation type to find
	 * @param annotationName the fully qualified class name of the annotation
	 * type to find (as an alternative to {@code annotationType})
	 * @param containerType the type of the container that holds repeatable
	 * annotations, or {@code null} if the annotation is not repeatable
	 * @param processor the processor to delegate to
	 * @param visited the set of annotated elements that have already been visited
	 * @param metaDepth the meta-depth of the annotation
	 * @return the result of the processor, potentially {@code null}
	 */
	private static <T> T searchWithGetSemantics(AnnotatedElement element, Class<? extends Annotation> annotationType,
			String annotationName, Class<? extends Annotation> containerType, Processor<T> processor,
			Set<AnnotatedElement> visited, int metaDepth) {

		Assert.notNull(element, "AnnotatedElement must not be null");

		if (visited.add(element)) {
			try {
				// Start searching within locally declared annotations
				List<Annotation> declaredAnnotations = Arrays.asList(element.getDeclaredAnnotations());
				T result = searchWithGetSemanticsInAnnotations(element, declaredAnnotations,
						annotationType, annotationName, containerType, processor, visited, metaDepth);
				if (result != null) {
					return result;
				}

				if (element instanceof Class) { // otherwise getAnnotations doesn't return anything new
					List<Annotation> inheritedAnnotations = new ArrayList<Annotation>();
					for (Annotation annotation : element.getAnnotations()) {
						if (!declaredAnnotations.contains(annotation)) {
							inheritedAnnotations.add(annotation);
						}
					}

					// Continue searching within inherited annotations
					result = searchWithGetSemanticsInAnnotations(element, inheritedAnnotations,
							annotationType, annotationName, containerType, processor, visited, metaDepth);
					if (result != null) {
						return result;
					}
				}
			}
			catch (Throwable ex) {
				AnnotationUtils.handleIntrospectionFailure(element, ex);
			}
		}

		return null;
	}
```
## step 2
```java
        /**
   	 * This method is invoked by {@link #searchWithGetSemantics} to perform
   	 * the actual search within the supplied list of annotations.
   	 * <p>This method should be invoked first with locally declared annotations
   	 * and then subsequently with inherited annotations, thereby allowing
   	 * local annotations to take precedence over inherited annotations.
   	 * <p>The {@code metaDepth} parameter is explained in the
   	 * {@link Processor#process process()} method of the {@link Processor} API.
   	 * @param element the element that is annotated with the supplied
   	 * annotations, used for contextual logging; may be {@code null} if unknown
   	 * @param annotations the annotations to search in
   	 * @param annotationType the annotation type to find
   	 * @param annotationName the fully qualified class name of the annotation
   	 * type to find (as an alternative to {@code annotationType})
   	 * @param containerType the type of the container that holds repeatable
   	 * annotations, or {@code null} if the annotation is not repeatable
   	 * @param processor the processor to delegate to
   	 * @param visited the set of annotated elements that have already been visited
   	 * @param metaDepth the meta-depth of the annotation
   	 * @return the result of the processor, potentially {@code null}
   	 * @since 4.2
   	 */
   	private static <T> T searchWithGetSemanticsInAnnotations(AnnotatedElement element,
   			List<Annotation> annotations, Class<? extends Annotation> annotationType, String annotationName,
   			Class<? extends Annotation> containerType, Processor<T> processor, Set<AnnotatedElement> visited,
   			int metaDepth) {
   
   		// Search in annotations
   		for (Annotation annotation : annotations) {
   			Class<? extends Annotation> currentAnnotationType = annotation.annotationType();
   			if (!AnnotationUtils.isInJavaLangAnnotationPackage(currentAnnotationType)) {
   				if (currentAnnotationType == annotationType ||
   						currentAnnotationType.getName().equals(annotationName) ||
   						processor.alwaysProcesses()) {
   					T result = processor.process(element, annotation, metaDepth);
   					if (result != null) {
   						if (processor.aggregates() && metaDepth == 0) {
   							processor.getAggregatedResults().add(result);
   						}
   						else {
   							return result;
   						}
   					}
   				}
   				// Repeatable annotations in container?
   				else if (currentAnnotationType == containerType) {
   					for (Annotation contained : getRawAnnotationsFromContainer(element, annotation)) {
   						T result = processor.process(element, contained, metaDepth);
   						if (result != null) {
   							// No need to post-process since repeatable annotations within a
   							// container cannot be composed annotations.
   							processor.getAggregatedResults().add(result);
   						}
   					}
   				}
   			}
   		}
   
   		// Recursively search in meta-annotations
   		for (Annotation annotation : annotations) {
   			Class<? extends Annotation> currentAnnotationType = annotation.annotationType();
   			if (!AnnotationUtils.isInJavaLangAnnotationPackage(currentAnnotationType)) {
   				T result = searchWithGetSemantics(currentAnnotationType, annotationType,
   						annotationName, containerType, processor, visited, metaDepth + 1);
   				if (result != null) {
   					processor.postProcess(element, annotation, result);
   					if (processor.aggregates() && metaDepth == 0) {
   						processor.getAggregatedResults().add(result);
   					}
   					else {
   						return result;
   					}
   				}
   			}
   		}
   
   		return null;
   	}```
   	
   	
