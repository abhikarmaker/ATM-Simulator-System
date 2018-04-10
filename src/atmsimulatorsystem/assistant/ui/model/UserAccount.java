/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmsimulatorsystem.assistant.ui.model;

import java.time.LocalDate;
import java.util.Date;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author USER
 */
public class UserAccount {

    private IntegerProperty user_id;
    private StringProperty first_name;
    private StringProperty middle_name;
    private StringProperty last_name;
    private StringProperty father_name;
    private StringProperty gender;
    private StringProperty email_address;
    private StringProperty marital_status;
    private StringProperty address;
    private StringProperty city;
    private StringProperty pin_code;
    private StringProperty state;
    private StringProperty religion;
    private StringProperty income;
    private StringProperty education_qualification;
    private StringProperty occupation;
    private StringProperty sin_number;
    private StringProperty status;
    private StringProperty existing_account;
    private StringProperty account_type;
    private StringProperty randomNumber;
    private StringProperty pinNumber;
    private StringProperty accountNumber;
    private StringProperty service_request;
    private LocalDate dateofBirth;
    
    public UserAccount() {
        this.user_id = new SimpleIntegerProperty();
        this.first_name = new SimpleStringProperty();
        this.middle_name = new SimpleStringProperty();
        this.last_name = new SimpleStringProperty();
        this.father_name = new SimpleStringProperty();
        this.gender = new SimpleStringProperty();
        this.email_address = new SimpleStringProperty();
        this.marital_status = new SimpleStringProperty();
        this.address = new SimpleStringProperty();
        this.city = new SimpleStringProperty();
        this.pin_code = new SimpleStringProperty();
        this.state = new SimpleStringProperty();
        this.religion = new SimpleStringProperty();
        this.income = new SimpleStringProperty();
        this.education_qualification = new SimpleStringProperty();
        this.occupation = new SimpleStringProperty();
        this.sin_number = new SimpleStringProperty();
        this.status = new SimpleStringProperty();
        this.existing_account = new SimpleStringProperty();
        this.account_type = new SimpleStringProperty();
        this.randomNumber = new SimpleStringProperty();
        this.pinNumber = new SimpleStringProperty();
        this.accountNumber = new SimpleStringProperty();
        this.service_request = new SimpleStringProperty();
        this.dateofBirth = dateofBirth;
    }

    public LocalDate getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(LocalDate dateofBirth) {
        this.dateofBirth = dateofBirth;
    }
    
    public int getUser_id() {
        return user_id.get();
    }

    public void setUser_id(int user_id) {
        this.user_id.set(user_id);
    }

    public String getFirst_name() {
        return first_name.get();
    }

    public void setFirst_name(String first_name) {
        this.first_name.set(first_name);
    }

    public String getMiddle_name() {
        return middle_name.get();
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name.set(middle_name);
    }

    public String getLast_name() {
        return last_name.get();
    }

    public void setLast_name(String last_name) {
        this.last_name.set(last_name);
    }

    public String getFather_name() {
        return father_name.get();
    }

    public void setFather_name(String father_name) {
        this.father_name.set(father_name);
    }

    public String getGender() {
        return gender.get();
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public String getEmail_address() {
        return email_address.get();
    }

    public void setEmail_address(String email_address) {
        this.email_address.set(email_address);
    }

    public String getMarital_status() {
        return marital_status.get();
    }

    public void setMarital_status(String marital_status) {
        this.marital_status.set(marital_status);
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getCity() {
        return city.get();
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getPin_code() {
        return pin_code.get();
    }

    public void setPin_code(String pin_code) {
        this.pin_code.set(pin_code);
    }

    public String getState() {
        return state.get();
    }

    public void setState(String state) {
        this.state.set(state);
    }
    
    public String getReligion() {
        return religion.get();
    }

    public void setReligion(String religion) {
        this.religion.set(religion);
    }

    public String getIncome() {
        return income.get();
    }

    public void setIncome(String income) {
        this.income.set(income);
    }

    public String getEducation_qualification() {
        return education_qualification.get();
    }

    public void setEducation_qualification(String education_qualification) {
        this.education_qualification.set(education_qualification);
    }

    public String getOccupation() {
        return occupation.get();
    }

    public void setOccupation(String occupation) {
        this.occupation.set(occupation);
    }

    public String getSin_number() {
        return sin_number.get();
    }

    public void setSin_number(String sin_number) {
        this.sin_number.set(sin_number);
    }

    public String getStatus() {
        return status.get();
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public String getExisting_account() {
        return existing_account.get();
    }

    public void setExisting_account(String existing_account) {
        this.existing_account.set(existing_account);
    }

    public String getAccount_type() {
        return account_type.get();
    }

    public void setAccount_type(String account_type) {
        this.account_type.set(account_type);
    }

    public String getRandomNumber() {
        return randomNumber.get();
    }

    public void setRandomNumber(String randomNumber) {
        this.randomNumber.set(randomNumber);
    }

    public String getPinNumber() {
        return pinNumber.get();
    }

    public void setPinNumber(String pin_code) {
        this.pinNumber.set(pin_code);
    }
    
    public String getAccountNumber() {
        return accountNumber.get();
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber.set(accountNumber);
    }
    
    public String getService_request() {
        return service_request.get();
    }

    public void setService_request(String service_request) {
        this.service_request.set(service_request);
    } 

}
