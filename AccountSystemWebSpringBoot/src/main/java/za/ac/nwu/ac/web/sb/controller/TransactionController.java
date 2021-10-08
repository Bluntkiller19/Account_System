package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.dto.TransactionDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.logic.flow.CreatTransactFlow;
import za.ac.nwu.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.logic.flow.FetchTransactFlow;
import za.ac.nwu.logic.flow.impl.CreatTransactFlowImpl;

import java.util.List;

@RestController
@RequestMapping("Account-Transaction")

public class TransactionController {

    private final FetchTransactFlow fetchTransactFlow;
    private final CreatTransactFlow creatTransactFlow;

    @Autowired
    public TransactionController(FetchTransactFlow fetchTransactFlow,
                                         @Qualifier("CreateTransactFlow")
                                                 CreatTransactFlow creatTransactFlow){
        this.fetchTransactFlow = fetchTransactFlow;
        this.creatTransactFlow = creatTransactFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all Transactions.", notes = "Returns a list of Transactions")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account types returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})

    public ResponseEntity<GeneralResponse<List<TransactionDto>>> getAll(){
        List<TransactionDto> transactions = fetchTransactFlow.getAllTransactions();
        GeneralResponse<List<TransactionDto>> response = new GeneralResponse<>(true, transactions);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Create a new AccountType", notes = "Create new AccountType in the DB")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The AccountType was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "internal server  error", response = GeneralResponse.class)})

    public ResponseEntity<GeneralResponse<TransactionDto>> create(
            @ApiParam(value = "Request body to create new AccountType", required = true)
            @RequestBody TransactionDto transact){
        TransactionDto transactResponse = creatTransactFlow.create(transact);
        GeneralResponse<TransactionDto> response = new GeneralResponse<>(true, transactResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /*@GetMapping("{mnemonic}")
    @ApiOperation(value = "Fetches the specified AccountType.", notes = "Fetches the accountType corresponding to the given mnemonic.")
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Goal found"),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Recourse Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountTypeDto>> getAccountType(
            @ApiParam(value = "The mnemonic that uniquely identifies the AccountType.",
                    example = "MILES",
                    name = "mnemonic",
                    required = true)
            @PathVariable("mnemonic") final String mnemonic){
        AccountTypeDto accountType = fetchTransactFlow.getAccountTypeByMnemonic(mnemonic);
        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true,accountType);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }*/
}
