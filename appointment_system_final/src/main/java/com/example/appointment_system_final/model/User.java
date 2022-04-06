package com.example.appointment_system_final.model;

import org.hibernate.annotations.NaturalId;

import com.example.appointment_system_final.audit.DateAudit;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "username"
        }),
        @UniqueConstraint(columnNames = {
            "email"
        })
})
public class User extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 40)
    private String name;

    @NotBlank
    @Size(max = 15)
    private String username;

    @NaturalId
    @NotBlank
    @Size(max = 40)
    @Email
    private String email;

    @NotBlank
    @Size(max = 100)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    
    
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    private List<Appointment> appointments;
//    
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    private List<Patient> patients;
//    
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    private List<Doctor> doctors;

    public User() {

    }

    public User(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

//	public List<Appointment> getAppointments() {
//		return appointments;
//	}
//
//	public void setAppointments(List<Appointment> appointments) {
//		this.appointments = appointments;
//	}
//
//	public List<Patient> getPatients() {
//		return patients;
//	}
//
//	public void setPatients(List<Patient> patients) {
//		this.patients = patients;
//	}
//
//	public List<Doctor> getDoctors() {
//		return doctors;
//	}
//
//	public void setDoctors(List<Doctor> doctors) {
//		this.doctors = doctors;
//	}

	

	
}
