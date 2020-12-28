package bmi.profession;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.FuzzyRuleSet;

public class Person {
    private final String fileName;
    private final float bmi;
    private final WorkType workType;
    private final int age;

    public Person(WorkType workType, String fileName, float bmi, int age) {
        this.fileName = fileName;
        this.bmi = bmi;
        this.workType = workType;
        this.age = age;
    }

    public void evaluate() {
        try {

            FIS fis = FIS.load(this.fileName,false);

            FuzzyRuleSet fuzzyRuleSet = fis.getFuzzyRuleSet();
            fuzzyRuleSet.chart();

            fuzzyRuleSet.setVariable(this.workType.toString(), this.bmi);
            fuzzyRuleSet.setVariable("age", this.age);

            fuzzyRuleSet.evaluate();

            fuzzyRuleSet.getVariable("weight_change").chartDefuzzifier(true);

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
