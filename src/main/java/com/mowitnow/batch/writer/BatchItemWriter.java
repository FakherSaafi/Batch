package com.mowitnow.batch.writer;

import com.mowitnow.Exception.ApplicationException;
import com.mowitnow.batch.dto.Data;
import com.mowitnow.entites.Pelouse;
import com.mowitnow.entites.PositionTondeuse;
import com.mowitnow.enums.InstructionTondeuse;
import com.mowitnow.parser.ParserTondeuse;
import com.mowitnow.traitement.TraitementTondeuse;
import com.mowitnow.Exception.ExceptionTondeuse;
import com.mowitnow.traitement.FormaterLigne;
import org.springframework.batch.core.scope.context.StepSynchronizationManager;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * Cette classe assure l'exécution séquentielle du traitement des tondeuses
 * @author Fakher Saafi
 */
@Component
public class BatchItemWriter implements ItemWriter<Data> {

    @Override
    public void write(List<? extends Data> list) throws Exception {
        if (list.size()!=2) throw new ExceptionTondeuse(ApplicationException.ERREUR_DONNEES_INCORRECTES);
        ExecutionContext jobContext = Objects.requireNonNull(StepSynchronizationManager.getContext()).getStepExecution().getJobExecution().getExecutionContext();
        ParserTondeuse parserTondeuse = new ParserTondeuse();
        parserTondeuse.setPelouse((String)jobContext.get("pelouse"));
        parserTondeuse.setTondeuse(list.get(0).getLine());
        parserTondeuse.setInstructions(list.get(1).getLine());
        System.out.println(parserEtLancerTraitement(parserTondeuse));
    }

    private String parserEtLancerTraitement(ParserTondeuse parser)
            throws ExceptionTondeuse {
        if (!parser.executeParseValidation()) {
            throw new ExceptionTondeuse(ApplicationException.ERREUR_DONNEES_INCORRECTES);
        } else {
            TraitementTondeuse traitement = new TraitementTondeuse();
            Pelouse pelouse = FormaterLigne.formaterLignePelouse(parser.getPelouse());
            PositionTondeuse positionTondeuse = FormaterLigne.formaterLigneTondeuse(parser.getTondeuse());
            List<InstructionTondeuse> instructions = FormaterLigne.formaterLigneInstruction(parser.getInstructions());
            traitement.setPelouse(pelouse);
            traitement.setPositionTondeuse(positionTondeuse);
            traitement.setListeInstruction(instructions);
            traitement.executerInstructions();
            return traitement.toString();
        }
    }
}
