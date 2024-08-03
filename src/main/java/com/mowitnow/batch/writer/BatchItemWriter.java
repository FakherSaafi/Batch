package com.mowitnow.batch.writer;

import com.mowitnow.Exception.ApplicationException;
import com.mowitnow.batch.dto.Data;
import com.mowitnow.entites.Pelouse;
import com.mowitnow.entites.TondeusePosition;
import com.mowitnow.enums.InstructionTondeuse;
import com.mowitnow.parser.ParserTondeuse;
import com.mowitnow.Process.TondeuseProcess;
import com.mowitnow.Exception.ExceptionTondeuse;
import com.mowitnow.Process.FormatLine;
import org.springframework.batch.core.scope.context.StepSynchronizationManager;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * This class ensures the sequential execution of the Tondeuse processing.
 * @author Fakher Saafi
 */
@Component
public class BatchItemWriter implements ItemWriter<Data> {

    @Override
    public void write(List<? extends Data> list) throws Exception {
        if (list.size()!=2) throw new ExceptionTondeuse(ApplicationException.ERROR_INCORRECT_DATA);
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
            throw new ExceptionTondeuse(ApplicationException.ERROR_INCORRECT_DATA);
        } else {
            TondeuseProcess traitement = new TondeuseProcess();
            Pelouse pelouse = FormatLine.formaterLignePelouse(parser.getPelouse());
            TondeusePosition tondeusePosition = FormatLine.formaterLigneTondeuse(parser.getTondeuse());
            List<InstructionTondeuse> instructions = FormatLine.formaterLigneInstruction(parser.getInstructions());
            traitement.setPelouse(pelouse);
            traitement.setTondeusePosition(tondeusePosition);
            traitement.setListeInstruction(instructions);
            traitement.executerInstructions();
            return traitement.toString();
        }
    }
}
