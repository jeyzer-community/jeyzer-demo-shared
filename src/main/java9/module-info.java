/**
 * Jeyzer demo shared module
 */
module org.jeyzer.demo.shared {
	
	exports org.jeyzer.demo.shared;
	
	requires java.base;
	requires java.management;
	requires org.slf4j;
	
	requires static org.jeyzer.annotations;

}