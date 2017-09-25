/*
 * huiguan.com Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package rule;

import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO desc
 *
 * @author huangchunbo
 * @since $$Revision:1.0.0, $$Date: 2017/9/25 19:05 $$
 */
public class Test extends TestCase {
    public void testFeeRule() {
        Map context = new HashMap();
        context.put("fee", 0.0);

        context.put("salary", 1000);
        RuleEngine ruleEngine = new RuleEngineDefault();
        ruleEngine.execute(context, "feerule");
        assertEquals(0, context.get("fee"));

        context.put("salary", 4000);
        ruleEngine.execute(context, "feerule");
        assertEquals(15.0, context.get("fee"));

        context.put("salary", 7000);
        ruleEngine.execute(context, "feerule");
        assertEquals(245.0, context.get("fee"));

        context.put("salary", 21000);
        ruleEngine.execute(context, "feerule");
        assertEquals(3370.0, context.get("fee"));

        context.put("salary", 40005);
        ruleEngine.execute(context, "feerule");
        assertEquals(8196.50, context.get("fee"));

        context.put("salary", 70005);
        ruleEngine.execute(context, "feerule");
        assertEquals(17771.75, context.get("fee"));

        context.put("salary", 100000);
        ruleEngine.execute(context, "feerule");
        assertEquals(29920.00, context.get("fee"));
    }
}
