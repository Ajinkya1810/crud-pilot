package CrudPilot.Entity;

import CrudPilot.Constants.DataModelConstants;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = DataModelConstants.TRANSACTION_LOG_TABLE)
public class TransactionLogDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String createdBy;
    private Timestamp createdDate;
    private String operation;
    private String request;

}
