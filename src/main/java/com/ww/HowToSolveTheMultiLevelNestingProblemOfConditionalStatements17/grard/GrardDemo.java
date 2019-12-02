package com.ww.HowToSolveTheMultiLevelNestingProblemOfConditionalStatements17.grard;

/**
 * @author: Sun
 * @create: 2019-12-02 17:48
 * @version: v1.0
 */
public class GrardDemo {

    public double getSalary(Integer position) {
        double result;
        if (position == null) {
            throw new IllegalArgumentException("职位不能为空");
        }

        // 老板
        if (isBoss(position)) {
            result = getBossSalary();
        } else {
            // 领导
            if (isLeader(position)) {
                result = getLeaderSalary();
            } else {
                // 普通员工
                result = getStaffSalary();
            }
        }
        return result;
    }

    /**
     * 卫语句形式取代嵌套条件表达式
     *
     * @param position
     * @return
     */
    public double getSalaryGuard(Integer position) {

        // 第1处代码:某个条件极其罕见，就应该单独检查该条件，并在条件为真时立即从函数返回。
        if (position == null) {
            throw new IllegalArgumentException("职位不能为空");
        }

        // 下面代码将某个分支条件转化成卫语句。

        // 老板
        if (isBoss(position)) {
            return getBossSalary();
        }
        // 领导
        if (isLeader(position)) {
            return getLeaderSalary();
        }
        // 普通员工
        return getStaffSalary();
    }

    private boolean isBoss(Integer position) {
        if (position == 1)
            return true;

        return false;
    }

    private boolean isLeader(Integer position) {
        if (position == 2)
            return true;

        return false;
    }

    private double getBossSalary() {
        return 10000D;
    }

    private double getLeaderSalary() {
        return 5000D;
    }

    private double getStaffSalary() {
        return 3000D;
    }
}
