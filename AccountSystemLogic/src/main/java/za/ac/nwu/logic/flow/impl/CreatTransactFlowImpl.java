package za.ac.nwu.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.TransactionDto;
import za.ac.nwu.ac.translator.TransactTranslator;
import za.ac.nwu.logic.flow.CreatTransactFlow;

import java.time.LocalDate;


@Component("CreateTransactFlow")
public class CreatTransactFlowImpl implements CreatTransactFlow {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreatTransactFlowImpl.class);

    private final TransactTranslator translator;

    public CreatTransactFlowImpl(TransactTranslator translator) {
        this.translator = translator;
    }

    @Override
    public TransactionDto create(TransactionDto transaction){

        LOGGER.info("The input object was {}", transaction);


        transaction.getTransaction().setTransactionId(null);

        if(null == transaction.getTxDate()){
            transaction.setTxDate(LocalDate.now());
        }
        return  translator.create(transaction);
    }
}
