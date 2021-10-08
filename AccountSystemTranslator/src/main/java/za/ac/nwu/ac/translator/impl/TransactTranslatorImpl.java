package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.TransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.repo.persistence.TransactRepository;
import za.ac.nwu.ac.translator.TransactTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransactTranslatorImpl implements TransactTranslator {

    private final TransactRepository transactRepository;

    @Autowired
    public TransactTranslatorImpl(TransactRepository transactRepository){
        this.transactRepository = transactRepository;
    }

    @Override
    public List<TransactionDto> getAllTransactions() {

        List<TransactionDto> transactionDtos = new ArrayList<>();
        try{
            for (AccountTransaction accountTransaction: transactRepository.findAll()){
                transactionDtos.add(new TransactionDto(accountTransaction));
            }
        }catch (Exception e){
            throw new RuntimeException("Unable to read from the DataBase!", e);
        }

        return transactionDtos;
    }

    @Override
    public TransactionDto create(TransactionDto transaction) {
        try {
            AccountTransaction accountTransaction = transactRepository.save(transaction.getTransaction());
            return new TransactionDto(accountTransaction);
        }catch (Exception e){
            throw new RuntimeException("Unable to save to DB",e);
        }
    }
}
