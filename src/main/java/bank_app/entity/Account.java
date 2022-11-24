package bank_app.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String acctFirstName;
    private String acctLastName;
    private String acctStatus;
    private Long acctNumber;
    private Double acctBalance;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Account(User user,
                   Long acctNumber) {
        this.acctFirstName = user.getFirstName();
        this.acctLastName = user.getLastName();
        this.acctNumber = acctNumber;
        this.acctBalance = 0.00;

    }

}
