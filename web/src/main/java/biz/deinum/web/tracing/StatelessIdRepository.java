package biz.deinum.web.tracing;

import biz.deinum.web.tracing.generator.UUIDIdGenerator;

import javax.servlet.ServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: in329dei
 * Date: 6-12-13
 * Time: 15:55
 * To change this template use File | Settings | File Templates.
 */
public class StatelessIdRepository implements IdRepository {

    private IdGenerator generator = new UUIDIdGenerator();

    @Override
    public String createOrGet(ServletRequest request) {
        return generator.generate(request);
    }
}
