/**
 * PlatformTransactionManager TransactionStatus TransactionDefinition
 * 
 * @EnableTransactionManagement
 * @Transactional Suppose you want to execute both transactional and some basic
 *                profiling advice. How do you effect this in the context of
 *                <tx:annotation-driven/>?
 * 
 *                When you invoke the updateFoo(Foo) method, you want to see the
 *                following actions:
 * 
 *                Configured profiling aspect starts up. Transactional advice
 *                executes. Method on the advised object executes. Transaction
 *                commits. Profiling aspect reports exact duration of the whole
 *                transactional method invocation.
 * @author donald 2017年12月6日 上午8:33:11
 */
package cn.home.modules.transaction;