package bpm;

import com.alibaba.compileflow.engine.ProcessEngine;
import java.util.HashMap;
import junit.framework.TestCase;
import com.alibaba.compileflow.engine.ProcessEngineFactory;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class SqrtFlow_TEST extends TestCase {


    @Test
    public void testProcess() throws Exception {
        String code = "bpm.sqrt";
        ProcessEngine engine = ProcessEngineFactory.getProcessEngine();
        System.out.println(engine.getJavaCode(code));
        Map<String, Object> context = new HashMap<String, Object>();
        context.put("num", null);
        try {
            System.out.println(engine.execute(code, context));
        }
        catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

}