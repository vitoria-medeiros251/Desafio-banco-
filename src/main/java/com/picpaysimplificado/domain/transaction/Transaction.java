package com.picpaysimplificado.domain.transaction;
import com.picpaysimplificado.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name= "transaction")
@Table(name= "transaction")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name="sender_id", nullable = false)
    private User sender;
    @ManyToOne
    @JoinColumn(name= "receiver_id", nullable = false)
    private User receiver;
    @Column(nullable = false)
    private LocalDateTime timestamp;




}
