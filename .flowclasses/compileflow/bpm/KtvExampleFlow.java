package compileflow.bpm;

import com.alibaba.compileflow.engine.runtime.instance.ProcessInstance;
import java.lang.Integer;
import java.util.List;
import com.alibaba.compileflow.engine.common.utils.DataType;
import com.alibaba.compileflow.demo.mock.MockJavaClazz;
import com.alibaba.compileflow.engine.process.preruntime.generator.script.ScriptExecutorProvider;
import com.ql.util.express.IExpressContext;
import java.lang.String;
import com.ql.util.express.DefaultContext;
import java.util.HashMap;
import com.alibaba.compileflow.demo.mock.MockSpringBean;
import java.util.Map;
import com.alibaba.compileflow.engine.common.utils.ObjectFactory;
import com.alibaba.compileflow.engine.process.preruntime.generator.bean.BeanProvider;

public class KtvExampleFlow implements ProcessInstance {

    private java.util.List<java.lang.String> pList = null;
    private java.lang.Integer price = null;
    private java.lang.Integer totalPrice = null;

    public Map<String, Object> execute(Map<String, Object> _pContext) throws Exception {
        pList = (List)DataType.transfer(_pContext.get("pList"), List.class);
        Map<String, Object> _pResult = new HashMap<>();
        int i = -1;
        for (String p : pList) {
            i++;
            //AutoTaskNode: 每人唱一首歌
            ((MockSpringBean)BeanProvider.getBean("mockSpringBean")).sing((String)DataType.transfer(p, String.class));
        }
        //DecisionNode: 计算费用
        mockJavaClazzCalPrice();
        if (totalPrice>=300) {
            //超过300
            {
                //ScriptTaskNode: 9折优惠
                IExpressContext<String, Object> nfScriptContext = new DefaultContext<>();
                nfScriptContext.put("price", totalPrice);
                price = (java.lang.Integer)ScriptExecutorProvider.getInstance().getScriptExecutor("QL").execute("(round(price*0.9,0)).intValue()", nfScriptContext);
            }
        } else {
            //不超过300
            {
                //ScriptTaskNode: 原价
                IExpressContext<String, Object> nfScriptContext = new DefaultContext<>();
                nfScriptContext.put("price", totalPrice);
                price = (java.lang.Integer)ScriptExecutorProvider.getInstance().getScriptExecutor("QL").execute("price*1", nfScriptContext);
            }
        }
        //AutoTaskNode: 付款
        ((MockSpringBean)BeanProvider.getBean("mockSpringBean")).payMoney(price);
        _pResult.put("price", price);
        return _pResult;
    }

    private void mockJavaClazzCalPrice() {
        totalPrice = ((MockJavaClazz)ObjectFactory.getInstance("com.alibaba.compileflow.demo.mock.MockJavaClazz")).calPrice((Integer)DataType.transfer(pList.size(), Integer.class));
    }

}