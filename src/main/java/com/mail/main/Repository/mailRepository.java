package com.mail.main.Repository;

import com.mail.main.Entity.Mail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface mailRepository extends JpaRepository<Mail, Long> {



}
