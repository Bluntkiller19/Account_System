package za.ac.nwu.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.TransactionDto;
import za.ac.nwu.ac.translator.TransactTranslator;
import za.ac.nwu.logic.flow.FetchTransactFlow;

import java.util.List;

@Component
public class FetchTransactFlowIml implements FetchTransactFlow {

    private final TransactTranslator translator;

    public FetchTransactFlowIml(TransactTranslator translator) {
        this.translator = translator;
    }


    @Override
    public List<TransactionDto> getAllTransactions(){
        return translator.getAllTransactions();
    }
}
