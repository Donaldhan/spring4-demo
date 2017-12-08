/**
 * Just like other services in the Spring Framework, the caching service is an
 * abstraction (not a cache implementation) and requires the use of an actual
 * storage to store the cache data - that is, the abstraction frees the
 * developer from having to write the caching logic but does not provide the
 * actual stores. This abstraction is materialized by the
 * org.springframework.cache.Cache and org.springframework.cache.CacheManager
 * interfaces.
 * 
 * There are a few implementations of that abstraction available out of the box:
 * JDK java.util.concurrent.ConcurrentMap based caches, Ehcache 2.x, Gemfire
 * cache, Caffeine, Guava caches and JSR-107 compliant caches (e.g. Ehcache
 * 3.x). See Section 36.7, “Plugging-in different back-end caches” for more
 * information on plugging in other cache stores/providers. For caching
 * declaration, the abstraction provides a set of Java annotations:
 * 
 * @Cacheable triggers cache population
 * @CacheEvict triggers cache eviction
 * @CachePut updates the cache without interfering with the method execution
 * @Caching regroups multiple cache operations to be applied on a method
 * @CacheConfig shares some common cache-related settings at class-level
 * 
 * @Cacheable
 * 
 * JCache
 * 			KeyGenerator
 * @author donald 2017年12月8日 下午12:59:30
 */
package cn.home.modules.cached;