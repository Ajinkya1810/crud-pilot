package CrudPilot.ServiceImplementations;

import CrudPilot.Entity.TransactionLogDetails;
import CrudPilot.Repositories.TransactionRepository;
import CrudPilot.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionLogService implements TransactionService {

    @Autowired
    TransactionRepository txnRepo;

    @Override
    public TransactionLogDetails save(TransactionLogDetails txnLogObj) {
        return txnRepo.save(txnLogObj);
    }
}
