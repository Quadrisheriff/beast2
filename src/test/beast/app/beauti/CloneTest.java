package test.beast.app.beauti;





import java.io.File;

import org.fest.swing.fixture.JButtonFixture;
import org.fest.swing.fixture.JCheckBoxFixture;
import org.fest.swing.fixture.JComboBoxFixture;
import org.fest.swing.fixture.JListFixture;
import org.fest.swing.fixture.JTabbedPaneFixture;
import org.fest.swing.fixture.JTableFixture;
import org.fest.swing.fixture.JTextComponentFixture;
import org.junit.Test;


public class CloneTest extends BeautiBase {

 	@Test
 	public void simpleSiteModelCloneTest() throws Exception {
        warning("0. Load primate-mtDNA.nex");
        importAlignment("examples/nexus", new File("primate-mtDNA.nex"));

		JTabbedPaneFixture f = beautiFrame.tabbedPane();
		// may need to use the following when not running on Hudson
//        JOptionPaneFixture op = beautiFrame.optionPane();
//        if (op.target.isVisible()) {
//        	op.okButton().click();
//        }

        //1. Set the site model to HKY+G4 (estimated)
        warning("1. Set the site model of first partition to HKY+G4 (estimated)");
        f.selectTab("Site Model");
        JComboBoxFixture substModel = beautiFrame.comboBox("substModel");
        substModel.selectItem("HKY");

        JTextComponentFixture categoryCount = beautiFrame.textBox("gammaCategoryCount");
        categoryCount.setText("4");

        JCheckBoxFixture shapeIsEstimated = beautiFrame.checkBox("shape.isEstimated");
        shapeIsEstimated.check();
        printBeautiState(f);
        assertStateEquals("Tree.t:coding", "birthRate.t:coding", "Tree.t:noncoding", "birthRate.t:noncoding", "Tree.t:3rdpos", "birthRate.t:3rdpos", "Tree.t:1stpos", "birthRate.t:1stpos", "Tree.t:2ndpos", "birthRate.t:2ndpos", "kappa.s:coding", "gammaShape.s:coding", "freqParameter.s:coding");
        assertOperatorsEqual("YuleBirthRateScaler.t:coding", "YuleModelTreeScaler.t:coding", "YuleModelTreeRootScaler.t:coding", "YuleModelUniformOperator.t:coding", "YuleModelSubtreeSlide.t:coding", "YuleModelNarrow.t:coding", "YuleModelWide.t:coding", "YuleModelWilsonBalding.t:coding", "YuleBirthRateScaler.t:noncoding", "YuleModelTreeScaler.t:noncoding", "YuleModelTreeRootScaler.t:noncoding", "YuleModelUniformOperator.t:noncoding", "YuleModelSubtreeSlide.t:noncoding", "YuleModelNarrow.t:noncoding", "YuleModelWide.t:noncoding", "YuleModelWilsonBalding.t:noncoding", "YuleBirthRateScaler.t:3rdpos", "YuleModelTreeScaler.t:3rdpos", "YuleModelTreeRootScaler.t:3rdpos", "YuleModelUniformOperator.t:3rdpos", "YuleModelSubtreeSlide.t:3rdpos", "YuleModelNarrow.t:3rdpos", "YuleModelWide.t:3rdpos", "YuleModelWilsonBalding.t:3rdpos", "YuleBirthRateScaler.t:1stpos", "YuleModelTreeScaler.t:1stpos", "YuleModelTreeRootScaler.t:1stpos", "YuleModelUniformOperator.t:1stpos", "YuleModelSubtreeSlide.t:1stpos", "YuleModelNarrow.t:1stpos", "YuleModelWide.t:1stpos", "YuleModelWilsonBalding.t:1stpos", "YuleBirthRateScaler.t:2ndpos", "YuleModelTreeScaler.t:2ndpos", "YuleModelTreeRootScaler.t:2ndpos", "YuleModelUniformOperator.t:2ndpos", "YuleModelSubtreeSlide.t:2ndpos", "YuleModelNarrow.t:2ndpos", "YuleModelWide.t:2ndpos", "YuleModelWilsonBalding.t:2ndpos", "KappaScaler.s:coding", "gammaShapeScaler.s:coding", "FrequenciesExchanger.s:coding");
        assertPriorsEqual("YuleModel.t:coding", "YuleModel.t:noncoding", "YuleModel.t:1stpos", "YuleModel.t:2ndpos", "YuleModel.t:3rdpos", "YuleBirthRatePrior.t:coding", "YuleBirthRatePrior.t:noncoding", "YuleBirthRatePrior.t:3rdpos", "YuleBirthRatePrior.t:1stpos", "YuleBirthRatePrior.t:2ndpos", "KappaPrior.s:coding", "GammaShapePrior.s:coding", "FrequenciesPrior.s:coding");
        assertTraceLogEqual("posterior", "likelihood", "prior", "treeLikelihood.coding", "TreeHeight.t:coding", "YuleModel.t:coding", "birthRate.t:coding", "treeLikelihood.noncoding", "TreeHeight.t:noncoding", "YuleModel.t:noncoding", "birthRate.t:noncoding", "treeLikelihood.3rdpos", "TreeHeight.t:3rdpos", "YuleModel.t:3rdpos", "birthRate.t:3rdpos", "treeLikelihood.1stpos", "TreeHeight.t:1stpos", "YuleModel.t:1stpos", "birthRate.t:1stpos", "treeLikelihood.2ndpos", "TreeHeight.t:2ndpos", "YuleModel.t:2ndpos", "birthRate.t:2ndpos", "kappa.s:coding", "gammaShape.s:coding", "freqParameter.s:coding");

        //2. select all models, clone from first model
        warning("2. select all models, clone from first model");
        JListFixture partitionlist = beautiFrame.list("listOfPartitions");
        partitionlist.selectItems(0, 1, 2, 3, 4);
        
        JButtonFixture cloneButton = beautiFrame.button("ok");
        cloneButton.click();
        printBeautiState(f);
        assertStateEquals("Tree.t:1stpos", "birthRate.t:1stpos", "Tree.t:coding", "birthRate.t:coding", "Tree.t:3rdpos", "birthRate.t:3rdpos", "Tree.t:2ndpos", "birthRate.t:2ndpos", "Tree.t:noncoding", "birthRate.t:noncoding", "kappa.s:coding", "gammaShape.s:coding", "gammaShape.s:noncoding", "kappa.s:noncoding", "gammaShape.s:1stpos", "kappa.s:1stpos", "gammaShape.s:2ndpos", "kappa.s:2ndpos", "gammaShape.s:3rdpos", "kappa.s:3rdpos", "freqParameter.s:1stpos", "freqParameter.s:3rdpos", "freqParameter.s:2ndpos", "freqParameter.s:noncoding", "freqParameter.s:coding");
        assertOperatorsEqual("YuleBirthRateScaler.t:1stpos", "YuleModelTreeScaler.t:1stpos", "YuleModelTreeRootScaler.t:1stpos", "YuleModelUniformOperator.t:1stpos", "YuleModelSubtreeSlide.t:1stpos", "YuleModelNarrow.t:1stpos", "YuleModelWide.t:1stpos", "YuleModelWilsonBalding.t:1stpos", "YuleBirthRateScaler.t:coding", "YuleModelTreeScaler.t:coding", "YuleModelTreeRootScaler.t:coding", "YuleModelUniformOperator.t:coding", "YuleModelSubtreeSlide.t:coding", "YuleModelNarrow.t:coding", "YuleModelWide.t:coding", "YuleModelWilsonBalding.t:coding", "YuleBirthRateScaler.t:3rdpos", "YuleModelTreeScaler.t:3rdpos", "YuleModelTreeRootScaler.t:3rdpos", "YuleModelUniformOperator.t:3rdpos", "YuleModelSubtreeSlide.t:3rdpos", "YuleModelNarrow.t:3rdpos", "YuleModelWide.t:3rdpos", "YuleModelWilsonBalding.t:3rdpos", "YuleBirthRateScaler.t:2ndpos", "YuleModelTreeScaler.t:2ndpos", "YuleModelTreeRootScaler.t:2ndpos", "YuleModelUniformOperator.t:2ndpos", "YuleModelSubtreeSlide.t:2ndpos", "YuleModelNarrow.t:2ndpos", "YuleModelWide.t:2ndpos", "YuleModelWilsonBalding.t:2ndpos", "YuleBirthRateScaler.t:noncoding", "YuleModelTreeScaler.t:noncoding", "YuleModelTreeRootScaler.t:noncoding", "YuleModelUniformOperator.t:noncoding", "YuleModelSubtreeSlide.t:noncoding", "YuleModelNarrow.t:noncoding", "YuleModelWide.t:noncoding", "YuleModelWilsonBalding.t:noncoding", "KappaScaler.s:coding", "gammaShapeScaler.s:coding", "gammaShapeScaler.s:noncoding", "KappaScaler.s:noncoding", "gammaShapeScaler.s:1stpos", "KappaScaler.s:1stpos", "gammaShapeScaler.s:2ndpos", "KappaScaler.s:2ndpos", "gammaShapeScaler.s:3rdpos", "KappaScaler.s:3rdpos", "FrequenciesExchanger.s:1stpos", "FrequenciesExchanger.s:3rdpos", "FrequenciesExchanger.s:2ndpos", "FrequenciesExchanger.s:noncoding", "FrequenciesExchanger.s:coding");
        assertPriorsEqual("YuleModel.t:coding", "YuleModel.t:noncoding", "YuleModel.t:1stpos", "YuleModel.t:2ndpos", "YuleModel.t:3rdpos", "YuleBirthRatePrior.t:1stpos", "YuleBirthRatePrior.t:coding", "YuleBirthRatePrior.t:3rdpos", "YuleBirthRatePrior.t:2ndpos", "YuleBirthRatePrior.t:noncoding", "KappaPrior.s:coding", "GammaShapePrior.s:coding", "GammaShapePrior.s:noncoding", "KappaPrior.s:noncoding", "GammaShapePrior.s:1stpos", "KappaPrior.s:1stpos", "GammaShapePrior.s:2ndpos", "KappaPrior.s:2ndpos", "GammaShapePrior.s:3rdpos", "KappaPrior.s:3rdpos", "FrequenciesPrior.s:coding", "FrequenciesPrior.s:noncoding", "FrequenciesPrior.s:1stpos", "FrequenciesPrior.s:2ndpos", "FrequenciesPrior.s:3rdpos");
        assertTraceLogEqual("posterior", "likelihood", "prior", "treeLikelihood.1stpos", "TreeHeight.t:1stpos", "YuleModel.t:1stpos", "birthRate.t:1stpos", "treeLikelihood.coding", "TreeHeight.t:coding", "YuleModel.t:coding", "birthRate.t:coding", "treeLikelihood.3rdpos", "TreeHeight.t:3rdpos", "YuleModel.t:3rdpos", "birthRate.t:3rdpos", "treeLikelihood.2ndpos", "TreeHeight.t:2ndpos", "YuleModel.t:2ndpos", "birthRate.t:2ndpos", "treeLikelihood.noncoding", "TreeHeight.t:noncoding", "YuleModel.t:noncoding", "birthRate.t:noncoding", "kappa.s:coding", "gammaShape.s:coding", "gammaShape.s:noncoding", "kappa.s:noncoding", "gammaShape.s:1stpos", "kappa.s:1stpos", "gammaShape.s:2ndpos", "kappa.s:2ndpos", "gammaShape.s:3rdpos", "kappa.s:3rdpos", "freqParameter.s:1stpos", "freqParameter.s:3rdpos", "freqParameter.s:2ndpos", "freqParameter.s:noncoding", "freqParameter.s:coding");

        //3. set second model back to JC
        warning("3. select all models, clone from first model");
        partitionlist.selectItems(1);
        beautiFrame.comboBox("substModel").selectItem("JC69");
        beautiFrame.textBox("gammaCategoryCount").setText("6");
        printBeautiState(f);
        assertStateEquals("Tree.t:3rdpos", "birthRate.t:3rdpos", "Tree.t:2ndpos", "birthRate.t:2ndpos", "Tree.t:noncoding", "birthRate.t:noncoding", "Tree.t:coding", "birthRate.t:coding", "Tree.t:1stpos", "birthRate.t:1stpos", "kappa.s:coding", "gammaShape.s:coding", "gammaShape.s:noncoding", "kappa.s:1stpos", "gammaShape.s:1stpos", "kappa.s:2ndpos", "gammaShape.s:2ndpos", "kappa.s:3rdpos", "gammaShape.s:3rdpos", "freqParameter.s:2ndpos", "freqParameter.s:3rdpos", "freqParameter.s:1stpos", "freqParameter.s:coding");
        assertOperatorsEqual("YuleBirthRateScaler.t:3rdpos", "YuleModelTreeScaler.t:3rdpos", "YuleModelTreeRootScaler.t:3rdpos", "YuleModelUniformOperator.t:3rdpos", "YuleModelSubtreeSlide.t:3rdpos", "YuleModelNarrow.t:3rdpos", "YuleModelWide.t:3rdpos", "YuleModelWilsonBalding.t:3rdpos", "YuleBirthRateScaler.t:2ndpos", "YuleModelTreeScaler.t:2ndpos", "YuleModelTreeRootScaler.t:2ndpos", "YuleModelUniformOperator.t:2ndpos", "YuleModelSubtreeSlide.t:2ndpos", "YuleModelNarrow.t:2ndpos", "YuleModelWide.t:2ndpos", "YuleModelWilsonBalding.t:2ndpos", "YuleBirthRateScaler.t:noncoding", "YuleModelTreeScaler.t:noncoding", "YuleModelTreeRootScaler.t:noncoding", "YuleModelUniformOperator.t:noncoding", "YuleModelSubtreeSlide.t:noncoding", "YuleModelNarrow.t:noncoding", "YuleModelWide.t:noncoding", "YuleModelWilsonBalding.t:noncoding", "YuleBirthRateScaler.t:coding", "YuleModelTreeScaler.t:coding", "YuleModelTreeRootScaler.t:coding", "YuleModelUniformOperator.t:coding", "YuleModelSubtreeSlide.t:coding", "YuleModelNarrow.t:coding", "YuleModelWide.t:coding", "YuleModelWilsonBalding.t:coding", "YuleBirthRateScaler.t:1stpos", "YuleModelTreeScaler.t:1stpos", "YuleModelTreeRootScaler.t:1stpos", "YuleModelUniformOperator.t:1stpos", "YuleModelSubtreeSlide.t:1stpos", "YuleModelNarrow.t:1stpos", "YuleModelWide.t:1stpos", "YuleModelWilsonBalding.t:1stpos", "KappaScaler.s:coding", "gammaShapeScaler.s:coding", "gammaShapeScaler.s:noncoding", "KappaScaler.s:1stpos", "gammaShapeScaler.s:1stpos", "KappaScaler.s:2ndpos", "gammaShapeScaler.s:2ndpos", "KappaScaler.s:3rdpos", "gammaShapeScaler.s:3rdpos", "FrequenciesExchanger.s:2ndpos", "FrequenciesExchanger.s:3rdpos", "FrequenciesExchanger.s:1stpos", "FrequenciesExchanger.s:coding");
        assertPriorsEqual("YuleModel.t:coding", "YuleModel.t:noncoding", "YuleModel.t:1stpos", "YuleModel.t:2ndpos", "YuleModel.t:3rdpos", "YuleBirthRatePrior.t:3rdpos", "YuleBirthRatePrior.t:2ndpos", "YuleBirthRatePrior.t:noncoding", "YuleBirthRatePrior.t:coding", "YuleBirthRatePrior.t:1stpos", "KappaPrior.s:coding", "GammaShapePrior.s:coding", "GammaShapePrior.s:noncoding", "GammaShapePrior.s:1stpos", "KappaPrior.s:1stpos", "GammaShapePrior.s:2ndpos", "KappaPrior.s:2ndpos", "GammaShapePrior.s:3rdpos", "KappaPrior.s:3rdpos", "FrequenciesPrior.s:coding", "FrequenciesPrior.s:1stpos", "FrequenciesPrior.s:2ndpos", "FrequenciesPrior.s:3rdpos");
        assertTraceLogEqual("posterior", "likelihood", "prior", "treeLikelihood.3rdpos", "TreeHeight.t:3rdpos", "YuleModel.t:3rdpos", "birthRate.t:3rdpos", "treeLikelihood.2ndpos", "TreeHeight.t:2ndpos", "YuleModel.t:2ndpos", "birthRate.t:2ndpos", "treeLikelihood.noncoding", "TreeHeight.t:noncoding", "YuleModel.t:noncoding", "birthRate.t:noncoding", "treeLikelihood.coding", "TreeHeight.t:coding", "YuleModel.t:coding", "birthRate.t:coding", "treeLikelihood.1stpos", "TreeHeight.t:1stpos", "YuleModel.t:1stpos", "birthRate.t:1stpos", "kappa.s:coding", "gammaShape.s:coding", "gammaShape.s:noncoding", "kappa.s:1stpos", "gammaShape.s:1stpos", "kappa.s:2ndpos", "gammaShape.s:2ndpos", "kappa.s:3rdpos", "gammaShape.s:3rdpos", "freqParameter.s:2ndpos", "freqParameter.s:3rdpos", "freqParameter.s:1stpos", "freqParameter.s:coding");

        // set category count back to 1
        beautiFrame.checkBox("shape.isEstimated").uncheck();
        beautiFrame.textBox("gammaCategoryCount").setText("1");
        printBeautiState(f);
        assertStateEquals("Tree.t:3rdpos", "birthRate.t:3rdpos", "Tree.t:2ndpos", "birthRate.t:2ndpos", "Tree.t:noncoding", "birthRate.t:noncoding", "Tree.t:coding", "birthRate.t:coding", "Tree.t:1stpos", "birthRate.t:1stpos", "kappa.s:coding", "gammaShape.s:coding", "kappa.s:1stpos", "gammaShape.s:1stpos", "kappa.s:2ndpos", "gammaShape.s:2ndpos", "kappa.s:3rdpos", "gammaShape.s:3rdpos", "freqParameter.s:2ndpos", "freqParameter.s:3rdpos", "freqParameter.s:1stpos", "freqParameter.s:coding");
        assertOperatorsEqual("YuleBirthRateScaler.t:3rdpos", "YuleModelTreeScaler.t:3rdpos", "YuleModelTreeRootScaler.t:3rdpos", "YuleModelUniformOperator.t:3rdpos", "YuleModelSubtreeSlide.t:3rdpos", "YuleModelNarrow.t:3rdpos", "YuleModelWide.t:3rdpos", "YuleModelWilsonBalding.t:3rdpos", "YuleBirthRateScaler.t:2ndpos", "YuleModelTreeScaler.t:2ndpos", "YuleModelTreeRootScaler.t:2ndpos", "YuleModelUniformOperator.t:2ndpos", "YuleModelSubtreeSlide.t:2ndpos", "YuleModelNarrow.t:2ndpos", "YuleModelWide.t:2ndpos", "YuleModelWilsonBalding.t:2ndpos", "YuleBirthRateScaler.t:noncoding", "YuleModelTreeScaler.t:noncoding", "YuleModelTreeRootScaler.t:noncoding", "YuleModelUniformOperator.t:noncoding", "YuleModelSubtreeSlide.t:noncoding", "YuleModelNarrow.t:noncoding", "YuleModelWide.t:noncoding", "YuleModelWilsonBalding.t:noncoding", "YuleBirthRateScaler.t:coding", "YuleModelTreeScaler.t:coding", "YuleModelTreeRootScaler.t:coding", "YuleModelUniformOperator.t:coding", "YuleModelSubtreeSlide.t:coding", "YuleModelNarrow.t:coding", "YuleModelWide.t:coding", "YuleModelWilsonBalding.t:coding", "YuleBirthRateScaler.t:1stpos", "YuleModelTreeScaler.t:1stpos", "YuleModelTreeRootScaler.t:1stpos", "YuleModelUniformOperator.t:1stpos", "YuleModelSubtreeSlide.t:1stpos", "YuleModelNarrow.t:1stpos", "YuleModelWide.t:1stpos", "YuleModelWilsonBalding.t:1stpos", "KappaScaler.s:coding", "gammaShapeScaler.s:coding", "KappaScaler.s:1stpos", "gammaShapeScaler.s:1stpos", "KappaScaler.s:2ndpos", "gammaShapeScaler.s:2ndpos", "KappaScaler.s:3rdpos", "gammaShapeScaler.s:3rdpos", "FrequenciesExchanger.s:2ndpos", "FrequenciesExchanger.s:3rdpos", "FrequenciesExchanger.s:1stpos", "FrequenciesExchanger.s:coding");
        assertPriorsEqual("YuleModel.t:coding", "YuleModel.t:noncoding", "YuleModel.t:1stpos", "YuleModel.t:2ndpos", "YuleModel.t:3rdpos", "YuleBirthRatePrior.t:3rdpos", "YuleBirthRatePrior.t:2ndpos", "YuleBirthRatePrior.t:noncoding", "YuleBirthRatePrior.t:coding", "YuleBirthRatePrior.t:1stpos", "KappaPrior.s:coding", "GammaShapePrior.s:coding", "GammaShapePrior.s:1stpos", "KappaPrior.s:1stpos", "GammaShapePrior.s:2ndpos", "KappaPrior.s:2ndpos", "GammaShapePrior.s:3rdpos", "KappaPrior.s:3rdpos", "FrequenciesPrior.s:coding", "FrequenciesPrior.s:1stpos", "FrequenciesPrior.s:2ndpos", "FrequenciesPrior.s:3rdpos");
        assertTraceLogEqual("posterior", "likelihood", "prior", "treeLikelihood.3rdpos", "TreeHeight.t:3rdpos", "YuleModel.t:3rdpos", "birthRate.t:3rdpos", "treeLikelihood.2ndpos", "TreeHeight.t:2ndpos", "YuleModel.t:2ndpos", "birthRate.t:2ndpos", "treeLikelihood.noncoding", "TreeHeight.t:noncoding", "YuleModel.t:noncoding", "birthRate.t:noncoding", "treeLikelihood.coding", "TreeHeight.t:coding", "YuleModel.t:coding", "birthRate.t:coding", "treeLikelihood.1stpos", "TreeHeight.t:1stpos", "YuleModel.t:1stpos", "birthRate.t:1stpos", "kappa.s:coding", "gammaShape.s:coding", "kappa.s:1stpos", "gammaShape.s:1stpos", "kappa.s:2ndpos", "gammaShape.s:2ndpos", "kappa.s:3rdpos", "gammaShape.s:3rdpos", "freqParameter.s:2ndpos", "freqParameter.s:3rdpos", "freqParameter.s:1stpos", "freqParameter.s:coding");


        // 4. clone second model to first model
        warning("4. clone second model to first model");
        beautiFrame.list("listOfPartitions").selectItems(0, 1);
        beautiFrame.comboBox().selectItem(1);
        beautiFrame.button("ok").click();
        
        printBeautiState(f);
        assertStateEquals("Tree.t:3rdpos", "birthRate.t:3rdpos", "Tree.t:2ndpos", "birthRate.t:2ndpos", "Tree.t:noncoding", "birthRate.t:noncoding", "Tree.t:coding", "birthRate.t:coding", "Tree.t:1stpos", "birthRate.t:1stpos", "kappa.s:1stpos", "gammaShape.s:1stpos", "kappa.s:2ndpos", "gammaShape.s:2ndpos", "kappa.s:3rdpos", "gammaShape.s:3rdpos", "freqParameter.s:2ndpos", "freqParameter.s:3rdpos", "freqParameter.s:1stpos");
        assertOperatorsEqual("YuleBirthRateScaler.t:3rdpos", "YuleModelTreeScaler.t:3rdpos", "YuleModelTreeRootScaler.t:3rdpos", "YuleModelUniformOperator.t:3rdpos", "YuleModelSubtreeSlide.t:3rdpos", "YuleModelNarrow.t:3rdpos", "YuleModelWide.t:3rdpos", "YuleModelWilsonBalding.t:3rdpos", "YuleBirthRateScaler.t:2ndpos", "YuleModelTreeScaler.t:2ndpos", "YuleModelTreeRootScaler.t:2ndpos", "YuleModelUniformOperator.t:2ndpos", "YuleModelSubtreeSlide.t:2ndpos", "YuleModelNarrow.t:2ndpos", "YuleModelWide.t:2ndpos", "YuleModelWilsonBalding.t:2ndpos", "YuleBirthRateScaler.t:noncoding", "YuleModelTreeScaler.t:noncoding", "YuleModelTreeRootScaler.t:noncoding", "YuleModelUniformOperator.t:noncoding", "YuleModelSubtreeSlide.t:noncoding", "YuleModelNarrow.t:noncoding", "YuleModelWide.t:noncoding", "YuleModelWilsonBalding.t:noncoding", "YuleBirthRateScaler.t:coding", "YuleModelTreeScaler.t:coding", "YuleModelTreeRootScaler.t:coding", "YuleModelUniformOperator.t:coding", "YuleModelSubtreeSlide.t:coding", "YuleModelNarrow.t:coding", "YuleModelWide.t:coding", "YuleModelWilsonBalding.t:coding", "YuleBirthRateScaler.t:1stpos", "YuleModelTreeScaler.t:1stpos", "YuleModelTreeRootScaler.t:1stpos", "YuleModelUniformOperator.t:1stpos", "YuleModelSubtreeSlide.t:1stpos", "YuleModelNarrow.t:1stpos", "YuleModelWide.t:1stpos", "YuleModelWilsonBalding.t:1stpos", "KappaScaler.s:1stpos", "gammaShapeScaler.s:1stpos", "KappaScaler.s:2ndpos", "gammaShapeScaler.s:2ndpos", "KappaScaler.s:3rdpos", "gammaShapeScaler.s:3rdpos", "FrequenciesExchanger.s:2ndpos", "FrequenciesExchanger.s:3rdpos", "FrequenciesExchanger.s:1stpos");
        assertPriorsEqual("YuleModel.t:coding", "YuleModel.t:noncoding", "YuleModel.t:1stpos", "YuleModel.t:2ndpos", "YuleModel.t:3rdpos", "YuleBirthRatePrior.t:3rdpos", "YuleBirthRatePrior.t:2ndpos", "YuleBirthRatePrior.t:noncoding", "YuleBirthRatePrior.t:coding", "YuleBirthRatePrior.t:1stpos", "GammaShapePrior.s:1stpos", "KappaPrior.s:1stpos", "GammaShapePrior.s:2ndpos", "KappaPrior.s:2ndpos", "GammaShapePrior.s:3rdpos", "KappaPrior.s:3rdpos", "FrequenciesPrior.s:1stpos", "FrequenciesPrior.s:2ndpos", "FrequenciesPrior.s:3rdpos");
        assertTraceLogEqual("posterior", "likelihood", "prior", "treeLikelihood.3rdpos", "TreeHeight.t:3rdpos", "YuleModel.t:3rdpos", "birthRate.t:3rdpos", "treeLikelihood.2ndpos", "TreeHeight.t:2ndpos", "YuleModel.t:2ndpos", "birthRate.t:2ndpos", "treeLikelihood.noncoding", "TreeHeight.t:noncoding", "YuleModel.t:noncoding", "birthRate.t:noncoding", "treeLikelihood.coding", "TreeHeight.t:coding", "YuleModel.t:coding", "birthRate.t:coding", "treeLikelihood.1stpos", "TreeHeight.t:1stpos", "YuleModel.t:1stpos", "birthRate.t:1stpos", "kappa.s:1stpos", "gammaShape.s:1stpos", "kappa.s:2ndpos", "gammaShape.s:2ndpos", "kappa.s:3rdpos", "gammaShape.s:3rdpos", "freqParameter.s:2ndpos", "freqParameter.s:3rdpos", "freqParameter.s:1stpos");

        makeSureXMLParses();       
	}


	/** robustly select rows -- don't give up after first attempt **/
	private void selectRows(int ... rows) {
		JTableFixture t = beautiFrame.table();
		for (int attempt = 0; attempt < 5; attempt++) {
			t.selectRows(rows);
			if (t.target.getSelectedRowCount() == rows.length) {
				return;
			}
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				
			}
		}
	}

	@Test
	public void simpleClockModelCloneTest() throws Exception {
        warning("0. Load primate-mtDNA.nex");
        importAlignment("examples/nexus", new File("primate-mtDNA.nex"));

		JTabbedPaneFixture f = beautiFrame.tabbedPane();
		// may need to use the following when not running on Hudson
//        JOptionPaneFixture op = beautiFrame.optionPane();
//	    if (op.target.isVisible()) {
//	    	op.okButton().click();
//	    }

		// 0. link trees
		f.selectTab("Partitions");
		selectRows(0,1,2,3,4);
		beautiFrame.button("Link Trees").click();

		
        //1. Set the clock model of second partition to UCLD exponential
        warning("1. Set the clock model of second partition to UCLD exponential");
        f.selectTab("Clock Model");
        beautiFrame.list("listOfPartitions").selectItems(1);
        beautiFrame.comboBox().selectItem("Relaxed Clock Exponential");
        printBeautiState(f);
        assertStateEquals("Tree.t:coding", "birthRate.t:coding", "clockRate.c:1stpos", "clockRate.c:3rdpos", "clockRate.c:2ndpos", "ucedMean.c:noncoding", "expRateCategories.c:noncoding");
        assertOperatorsEqual("YuleBirthRateScaler.t:coding", "YuleModelTreeScaler.t:coding", "YuleModelTreeRootScaler.t:coding", "YuleModelUniformOperator.t:coding", "YuleModelSubtreeSlide.t:coding", "YuleModelNarrow.t:coding", "YuleModelWide.t:coding", "YuleModelWilsonBalding.t:coding", "StrictClockRateScaler.c:1stpos", "strictClockUpDownOperator.c:1stpos", "StrictClockRateScaler.c:3rdpos", "strictClockUpDownOperator.c:3rdpos", "StrictClockRateScaler.c:2ndpos", "strictClockUpDownOperator.c:2ndpos", "ucedMeanScaler.c:noncoding", "ExpCategoriesRandomWalk.c:noncoding", "ExpCategoriesSwapOperator.c:noncoding", "ExpCategoriesUniform.c:noncoding", "relaxedUpDownOperatorExp.c:noncoding");
        assertPriorsEqual("YuleModel.t:coding", "YuleBirthRatePrior.t:coding", "ClockPrior.c:1stpos", "ClockPrior.c:3rdpos", "ClockPrior.c:2ndpos", "UCMeanRatePrior.c:noncoding");
        assertTraceLogEqual("posterior", "likelihood", "prior", "treeLikelihood.1stpos", "treeLikelihood.coding", "TreeHeight.t:coding", "YuleModel.t:coding", "birthRate.t:coding", "treeLikelihood.3rdpos", "treeLikelihood.2ndpos", "treeLikelihood.noncoding", "clockRate.c:1stpos", "clockRate.c:3rdpos", "clockRate.c:2ndpos", "ucedMean.c:noncoding", "rateStat.c:noncoding");


        //2. Clone to first and last partition 
        beautiFrame.list("listOfPartitions").selectItems(0,1,4);
        beautiFrame.comboBox().selectItem(1);
        beautiFrame.button("ok").click();
        printBeautiState(f);
        assertStateEquals("Tree.t:coding", "birthRate.t:coding", "clockRate.c:2ndpos", "clockRate.c:1stpos", "ucedMean.c:noncoding", "expRateCategories.c:noncoding", "expRateCategories.c:coding", "ucedMean.c:3rdpos", "expRateCategories.c:3rdpos");
        assertOperatorsEqual("YuleBirthRateScaler.t:coding", "YuleModelTreeScaler.t:coding", "YuleModelTreeRootScaler.t:coding", "YuleModelUniformOperator.t:coding", "YuleModelSubtreeSlide.t:coding", "YuleModelNarrow.t:coding", "YuleModelWide.t:coding", "YuleModelWilsonBalding.t:coding", "StrictClockRateScaler.c:2ndpos", "strictClockUpDownOperator.c:2ndpos", "StrictClockRateScaler.c:1stpos", "strictClockUpDownOperator.c:1stpos", "ucedMeanScaler.c:noncoding", "ExpCategoriesRandomWalk.c:noncoding", "ExpCategoriesSwapOperator.c:noncoding", "ExpCategoriesUniform.c:noncoding", "relaxedUpDownOperatorExp.c:noncoding", "ExpCategoriesRandomWalk.c:coding", "ExpCategoriesSwapOperator.c:coding", "ExpCategoriesUniform.c:coding", "ucedMeanScaler.c:3rdpos", "ExpCategoriesRandomWalk.c:3rdpos", "ExpCategoriesSwapOperator.c:3rdpos", "ExpCategoriesUniform.c:3rdpos", "relaxedUpDownOperatorExp.c:3rdpos");
        assertPriorsEqual("YuleModel.t:coding", "YuleBirthRatePrior.t:coding", "ClockPrior.c:2ndpos", "ClockPrior.c:1stpos", "UCMeanRatePrior.c:noncoding", "UCMeanRatePrior.c:3rdpos");
        assertTraceLogEqual("posterior", "likelihood", "prior", "treeLikelihood.2ndpos", "treeLikelihood.noncoding", "treeLikelihood.coding", "TreeHeight.t:coding", "YuleModel.t:coding", "birthRate.t:coding", "treeLikelihood.1stpos", "treeLikelihood.3rdpos", "clockRate.c:2ndpos", "clockRate.c:1stpos", "ucedMean.c:noncoding", "rateStat.c:noncoding", "rateStat.c:coding", "ucedMean.c:3rdpos", "rateStat.c:3rdpos");
        
        
        //3. Set the clock model of third partition to UCLD lognormal
        warning("3. Set the clock model of third partition to UCLD lognormal");
        beautiFrame.list("listOfPartitions").selectItems(2);
        beautiFrame.comboBox().selectItem("Relaxed Clock Log Normal");
        printBeautiState(f);
        assertStateEquals("Tree.t:coding", "birthRate.t:coding", "clockRate.c:2ndpos", "ucedMean.c:noncoding", "expRateCategories.c:noncoding", "expRateCategories.c:coding", "ucedMean.c:3rdpos", "expRateCategories.c:3rdpos", "ucldMean.c:1stpos", "ucldStdev.c:1stpos", "rateCategories.c:1stpos");
        assertOperatorsEqual("YuleBirthRateScaler.t:coding", "YuleModelTreeScaler.t:coding", "YuleModelTreeRootScaler.t:coding", "YuleModelUniformOperator.t:coding", "YuleModelSubtreeSlide.t:coding", "YuleModelNarrow.t:coding", "YuleModelWide.t:coding", "YuleModelWilsonBalding.t:coding", "StrictClockRateScaler.c:2ndpos", "strictClockUpDownOperator.c:2ndpos", "ucedMeanScaler.c:noncoding", "ExpCategoriesRandomWalk.c:noncoding", "ExpCategoriesSwapOperator.c:noncoding", "ExpCategoriesUniform.c:noncoding", "relaxedUpDownOperatorExp.c:noncoding", "ExpCategoriesRandomWalk.c:coding", "ExpCategoriesSwapOperator.c:coding", "ExpCategoriesUniform.c:coding", "ucedMeanScaler.c:3rdpos", "ExpCategoriesRandomWalk.c:3rdpos", "ExpCategoriesSwapOperator.c:3rdpos", "ExpCategoriesUniform.c:3rdpos", "relaxedUpDownOperatorExp.c:3rdpos", "ucldMeanScaler.c:1stpos", "ucldStdevScaler.c:1stpos", "CategoriesRandomWalk.c:1stpos", "CategoriesSwapOperator.c:1stpos", "CategoriesUniform.c:1stpos", "relaxedUpDownOperator.c:1stpos");
        assertPriorsEqual("YuleModel.t:coding", "YuleBirthRatePrior.t:coding", "ClockPrior.c:2ndpos", "UCMeanRatePrior.c:noncoding", "UCMeanRatePrior.c:3rdpos", "ucldStdevPrior.c:1stpos", "MeanRatePrior.c:1stpos");
        assertTraceLogEqual("posterior", "likelihood", "prior", "treeLikelihood.2ndpos", "treeLikelihood.3rdpos", "treeLikelihood.noncoding", "treeLikelihood.coding", "TreeHeight.t:coding", "YuleModel.t:coding", "birthRate.t:coding", "treeLikelihood.1stpos", "clockRate.c:2ndpos", "ucedMean.c:noncoding", "rateStat.c:noncoding", "rateStat.c:coding", "ucedMean.c:3rdpos", "rateStat.c:3rdpos", "ucldMean.c:1stpos", "ucldStdev.c:1stpos", "rate.c:1stpos");

        //4. Clone the third to fourth partition 
        warning("4. Clone the third to fourth partition");
        beautiFrame.list("listOfPartitions").selectItems(2,3);
        beautiFrame.comboBox().selectItem(2);
        beautiFrame.button("ok").click();
        printBeautiState(f);
        assertStateEquals("Tree.t:coding", "birthRate.t:coding", "ucedMean.c:noncoding", "expRateCategories.c:noncoding", "expRateCategories.c:coding", "ucedMean.c:3rdpos", "expRateCategories.c:3rdpos", "ucldMean.c:1stpos", "ucldStdev.c:1stpos", "rateCategories.c:1stpos", "ucldMean.c:2ndpos", "ucldStdev.c:2ndpos", "rateCategories.c:2ndpos");
        assertOperatorsEqual("YuleBirthRateScaler.t:coding", "YuleModelTreeScaler.t:coding", "YuleModelTreeRootScaler.t:coding", "YuleModelUniformOperator.t:coding", "YuleModelSubtreeSlide.t:coding", "YuleModelNarrow.t:coding", "YuleModelWide.t:coding", "YuleModelWilsonBalding.t:coding", "ucedMeanScaler.c:noncoding", "ExpCategoriesRandomWalk.c:noncoding", "ExpCategoriesSwapOperator.c:noncoding", "ExpCategoriesUniform.c:noncoding", "relaxedUpDownOperatorExp.c:noncoding", "ExpCategoriesRandomWalk.c:coding", "ExpCategoriesSwapOperator.c:coding", "ExpCategoriesUniform.c:coding", "ucedMeanScaler.c:3rdpos", "ExpCategoriesRandomWalk.c:3rdpos", "ExpCategoriesSwapOperator.c:3rdpos", "ExpCategoriesUniform.c:3rdpos", "relaxedUpDownOperatorExp.c:3rdpos", "ucldMeanScaler.c:1stpos", "ucldStdevScaler.c:1stpos", "CategoriesRandomWalk.c:1stpos", "CategoriesSwapOperator.c:1stpos", "CategoriesUniform.c:1stpos", "relaxedUpDownOperator.c:1stpos", "ucldMeanScaler.c:2ndpos", "ucldStdevScaler.c:2ndpos", "CategoriesRandomWalk.c:2ndpos", "CategoriesSwapOperator.c:2ndpos", "CategoriesUniform.c:2ndpos", "relaxedUpDownOperator.c:2ndpos");
        assertPriorsEqual("YuleModel.t:coding", "YuleBirthRatePrior.t:coding", "UCMeanRatePrior.c:noncoding", "UCMeanRatePrior.c:3rdpos", "ucldStdevPrior.c:1stpos", "MeanRatePrior.c:1stpos", "ucldStdevPrior.c:2ndpos", "MeanRatePrior.c:2ndpos");
        assertTraceLogEqual("posterior", "likelihood", "prior", "treeLikelihood.2ndpos", "treeLikelihood.noncoding", "treeLikelihood.coding", "TreeHeight.t:coding", "YuleModel.t:coding", "birthRate.t:coding", "treeLikelihood.1stpos", "treeLikelihood.3rdpos", "ucedMean.c:noncoding", "rateStat.c:noncoding", "rateStat.c:coding", "ucedMean.c:3rdpos", "rateStat.c:3rdpos", "ucldMean.c:1stpos", "ucldStdev.c:1stpos", "rate.c:1stpos", "ucldMean.c:2ndpos", "ucldStdev.c:2ndpos", "rate.c:2ndpos");
        
        
        makeSureXMLParses();
        
        System.err.println("done");
	}

}
