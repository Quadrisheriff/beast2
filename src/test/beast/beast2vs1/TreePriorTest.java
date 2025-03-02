package test.beast.beast2vs1;


import test.beast.beast2vs1.trace.Expectation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Walter Xie
 */
public class TreePriorTest extends TestFramework {
    private final String[] XML_FILES = new String[]{"testCoalescentNoClock.xml", "testCoalescentNoClock1.xml",
            "testExponentialGrowth.xml", "testYuleModel_10taxa.xml", "testBirthDeathModel_10taxa.xml",
            "testBirthDeathAsYule.xml", "testBSP1.xml", "testBSPNoClock.xml", "testEBSP.xml"};

    public void testCoalescentNoClock() throws Exception {
        analyse(0);
    }

    public void testCoalescentNoClock1() throws Exception {
        analyse(1);
    }

    public void testExponentialGrowth() throws Exception {
        analyse(2);
    }

    public void testYuleModel_10taxa() throws Exception {
        analyse(3);
    }

    public void testBirthDeathModel_10taxa() throws Exception {
        analyse(4);
    }

    public void testBirthDeathAsYule() throws Exception {
        analyse(5);
    }

    public void testBSP() throws Exception {
        analyse(6);
    }

    public void testBSPNoClock() throws Exception {
        analyse(7);
    }

    public void testEBSP() throws Exception {
        analyse(8);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp(XML_FILES);
    }

    @Override
	protected List<Expectation> giveExpectations(int index_XML) throws Exception {
        List<Expectation> expList = new ArrayList<Expectation>();

        // all values below are from BEAST 1.7
        switch (index_XML) {
            case 0: // testCoalescentNoClock.xml
//        BEAST 1 testCoalescentNoClock.xml
                addExpIntoList(expList, "posterior", -1813.059, 0.0569);
                addExpIntoList(expList, "prior", 3.705, 0.025);
                addExpIntoList(expList, "tree.height", 0.06318, 6.73E-05);
                addExpIntoList(expList, "popSize", 0.0979, 6.38E-04);
                addExpIntoList(expList, "hky.kappa", 26.262, 0.2217);
                addExpIntoList(expList, "hky.frequencies.1", 0.326, 6.04E-04);
                addExpIntoList(expList, "hky.frequencies.2", 0.258, 5.23E-04);
                addExpIntoList(expList, "hky.frequencies.3", 0.155, 4.03E-04);
                addExpIntoList(expList, "hky.frequencies.4", 0.261, 5.64E-04);
                addExpIntoList(expList, "treeLikelihood", -1816.764, 0.0556);
                addExpIntoList(expList, "coalescent", 7.242, 9.94E-03);
                break;

            case 1: // testCoalescentNoClock1.xml
//        BEAST 1 testCoalescentNoClock1.xml
                addExpIntoList(expList, "posterior", -1809.75, 5.96E-02);
                addExpIntoList(expList, "tree.height", 6.35E-02, 6.61E-05);
                addExpIntoList(expList, "popSize", 0.132, 0.2987);
                addExpIntoList(expList, "hky.kappa", 33.139, 0.1812);
                addExpIntoList(expList, "hky.frequencies.1", 0.326, 5.70E-04);
                addExpIntoList(expList, "hky.frequencies.2", 0.257, 6.15E-04);
                addExpIntoList(expList, "hky.frequencies.3", 0.154, 4.17E-04);
                addExpIntoList(expList, "hky.frequencies.4", 0.262, 4.91E-04);
                addExpIntoList(expList, "treeLikelihood", -1816.698, 5.82E-02);
                addExpIntoList(expList, "coalescent", 6.948, 1.24E-02);
                break;

            case 2: // testExponentialGrowth.xml
//        BEAST 1 testExponentialGrowthNoClock1.xml
                addExpIntoList(expList, "posterior", -1818.4448, 6.3697E-2);
                addExpIntoList(expList, "prior", -1.726, 3.6124E-2);
                addExpIntoList(expList, "tree.height", 6.1545E-2, 6.6865E-5);
                addExpIntoList(expList, "popSize", 1.0231, 5.1484E-2);
                addExpIntoList(expList, "growthRate", 58.5276, 0.6012);
                addExpIntoList(expList, "hky.kappa", 26.301, 0.211);
                addExpIntoList(expList, "hky.frequencies.1", 0.3266, 5.9862E-4);
                addExpIntoList(expList, "hky.frequencies.2", 0.2569, 5.3533E-4);
                addExpIntoList(expList, "hky.frequencies.3", 0.154, 4.0839E-4);
                addExpIntoList(expList, "hky.frequencies.4", 0.2625, 5.7627E-4);
                addExpIntoList(expList, "treeLikelihood", -1816.7188, 4.9732E-2);
                addExpIntoList(expList, "coalescent", 9.4203, 1.31E-2);
                break;

            case 3: // testYuleModel_10taxa.xml
//        BEAST 1 testYuleModel_10taxa.xml
                addExpIntoList(expList, "yule", -2.8068, 3.894E-2); // speciationLikelihood
                addExpIntoList(expList, "tree.height", 0.9702, 4.2554E-3);
                break;

            case 4: // testBirthDeathModel_10taxa.xml
//        BEAST 1 testBirthDeathModel_10taxa.xml
                addExpIntoList(expList, "birthDeath", 0.981, 4.9536E-2); // speciationLikelihood
                addExpIntoList(expList, "tree.height", 0.7017, 3.9048E-3);
                break;

            case 5: // testBirthDeathAsYule.xml
//        BEAST 1 testBirthDeathAsYule.xml
                addExpIntoList(expList, "posterior", -84.941, 2.3521E-2);
                addExpIntoList(expList, "birthDeath", -84.7945, 2.3471E-2); // speciationLikelihood
                addExpIntoList(expList, "birthRate", 1.1636, 3.8458E-3);
                break;

            case 6: // testBSP1.xml
//        BEAST 1 testBSP1.xml
                addExpIntoList(expList, "posterior", -3865.3635, 8.2236E-2);
                addExpIntoList(expList, "prior", -92.178, 7.5174E-2);
                addExpIntoList(expList, "siteModel.alpha", 5.4354E-2, 5.2519E-4);
                addExpIntoList(expList, "clock.rate", 9.4858E-4, 1.9706E-6);
                addExpIntoList(expList, "skyline.popSize.1", 67.8827, 2.2639);
                addExpIntoList(expList, "skyline.popSize.2", 25.4281, 0.3165);
                addExpIntoList(expList, "skyline.popSize.3", 31.9271, 0.3819);
                addExpIntoList(expList, "skyline.popSize.4", 41.6596, 0.3976);
                addExpIntoList(expList, "skyline.popSize.5", 33.5967, 0.3554);
                addExpIntoList(expList, "skyline.groupSize.1", 2.4686, 4.0465E-2);
                addExpIntoList(expList, "skyline.groupSize.2", 3.3671, 3.9454E-2);
                addExpIntoList(expList, "skyline.groupSize.3", 3.181, 3.3807E-2); // TODO diff bigger than 2*delta
                addExpIntoList(expList, "skyline.groupSize.4", 3.723, 5.0187E-2);
                addExpIntoList(expList, "skyline.groupSize.5", 3.2603, 5.9824E-2);
                addExpIntoList(expList, "hky.kappa", 21.6911, 5.2142E-2);
                addExpIntoList(expList, "treeModel.rootHeight", 70.3393, 0.1057);
                addExpIntoList(expList, "likelihood", -3773.1854, 3.9474E-2);
                addExpIntoList(expList, "skyline", -69.725, 5.435E-2);
                addExpIntoList(expList, "eml1", -22.453, 3.1115E-2);
                break;

            case 7: // testBSPNoClock.xml
//        BEAST 1 testBSPNoClock.xml
                addExpIntoList(expList, "posterior", -1809.8121, 7.6417E-2);
                addExpIntoList(expList, "prior", 7.0426, 3.7042E-2);
                addExpIntoList(expList, "tree.height", 6.2187E-2, 6.4148E-5);
                addExpIntoList(expList, "popSizes.1", 0.2084, 4.4215E-3);
                addExpIntoList(expList, "popSizes.2", 0.1012, 1.1132E-3);
                addExpIntoList(expList, "popSizes.3", 5.0552E-2, 7.8572E-4);
                addExpIntoList(expList, "groupSizes.1", 1.7396, 8.2581E-3);
                //addExpIntoList(expList, "groupSizes2", 1.78, 8.3052E-3); // TODO diff bigger than 2*delta
                addExpIntoList(expList, "groupSizes.3", 1.4804, 7.7151E-3);
                addExpIntoList(expList, "hky.kappa", 26.0187, 0.2286);
                addExpIntoList(expList, "hky.frequencies.1", 0.3262, 7.0596E-4);
                addExpIntoList(expList, "hky.frequencies.2", 0.2571, 5.876E-4);
                addExpIntoList(expList, "hky.frequencies.3", 0.1546, 4.8206E-4);
                addExpIntoList(expList, "hky.frequencies.4", 0.262, 5.9621E-4);
                addExpIntoList(expList, "treeLikelihood", -1816.8547, 6.3527E-2);
                addExpIntoList(expList, "skyline", 7.9513, 1.6384E-2);
                addExpIntoList(expList, "eml1", 5.059, 2.1669E-2);
                break;

            case 8: // testEBSP.xml
                // all values below are from BEAST 1.8.4, testEBSP.xml
                addExpIntoList(expList, "posterior", -3831.4728, 9.7013);
                addExpIntoList(expList, "prior", 458.7546, 9.6924);
                addExpIntoList(expList, "tree.26.height", 0.0275, 7.7632E-5);
                addExpIntoList(expList, "tree.29.height", 0.0231, 6.589E-5);
                addExpIntoList(expList, "tree.47.height", 0.0263, 6.5618E-5);
                addExpIntoList(expList, "sum(indicators)", 0.4738, 0.0187);
                addExpIntoList(expList, "populationMean", 0.0443, 0.0119);
                addExpIntoList(expList, "treeLikelihood.26", -1264.9419, 0.0819);
                addExpIntoList(expList, "treeLikelihood.29", -1246.7234, 0.0754);
                addExpIntoList(expList, "treeLikelihood.47", -1778.562, 0.0951);
                addExpIntoList(expList, "coalescent", 220.5613, 0.1462);
                addExpIntoList(expList, "popSizes.1", 0.0172, 3.9108E-3);
                addExpIntoList(expList, "popSizes.2", 0.0444, 0.0136);
                addExpIntoList(expList, "popSizes.3", 0.0397, 0.0103);
                addExpIntoList(expList, "indicators.1", 6.3871E-3, 1.7047E-3);
                addExpIntoList(expList, "indicators.2", 0.0192, 9.1203E-3);
                addExpIntoList(expList, "indicators.3", 9.4418E-3, 2.2312E-3);
                addExpIntoList(expList, "hky.kappa.26", 4.4946, 0.038);
                addExpIntoList(expList, "hky.frequencies.26.1", 0.4099, 8.0594E-4);
                addExpIntoList(expList, "hky.frequencies.26.2", 0.2064, 6.2073E-4);
                addExpIntoList(expList, "hky.frequencies.26.3", 0.1754, 5.6823E-4);
                addExpIntoList(expList, "hky.frequencies.26.4", 0.2083, 6.139E-4);
                break;


            default:
                throw new Exception("No such XML");
        }

        return expList;
    }


} // class ResumeTest