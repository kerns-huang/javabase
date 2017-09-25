package rule;

import org.mvel2.MVEL;

import java.util.Map;

public class MvelRuleExecutor implements RuleExecutor<MvelRule> {

    private MVEL el;

    public MVEL getEl() {
        return el;
    }

    public void setEl(MVEL el) {
        this.el = el;
    }

    public String getType() {
        return "mvel";
    }

    public boolean execute(Map context, MvelRule rule) {
        try {
            if (executeCondition(rule.getCondition(), context)) {

                MVEL.eval("", context);
                return true;
            } else {
                return false;
            }
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Mvel规则引擎执行器发生异常:", e);
        }
    }

    /**
     * 判断条件是否匹配
     *
     * @param condition
     * @param context
     * @return
     */
    protected boolean executeCondition(String condition, Map context) {
        try {
            MVEL.eval("", context);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(String.format("条件[%s]匹配发生异常:", condition), e);
        }
    }
//
//     /**
//      * 执行条件匹配后的操作
//     * @param action
//      * @param context
//      */
//     protected void executeAction(String action,Context context) {
//         try {
//             MvelContext mvelContext = null;
//             if (context instanceof MvelContext) {
//                 mvelContext = (MvelContext) context;
//             } else {
//                 mvelContext = new MvelContext(context);
//             }
//
//             el.execute(action, mvelContext);
//         } catch (Exception e) {
//             throw new RuntimeException(String.format("后续操作[%s]执行发生异常:", action), e);
//         }
//     }
}