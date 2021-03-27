
package com.joy.kafka.json.schema;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "EmployeeId",
    "FirstName",
    "LastName",
    "Age",
    "Sex",
    "Address"
})
public class Employee {

    @JsonProperty("EmployeeId")
    private String employeeId;
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("Age")
    private Integer age;
    @JsonProperty("Sex")
    private String sex;
    @JsonProperty("Address")
    private Address address;

    @JsonProperty("EmployeeId")
    public String getEmployeeId() {
        return employeeId;
    }

    @JsonProperty("EmployeeId")
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Employee withEmployeeId(String employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    @JsonProperty("FirstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("FirstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Employee withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @JsonProperty("LastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("LastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Employee withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @JsonProperty("Age")
    public Integer getAge() {
        return age;
    }

    @JsonProperty("Age")
    public void setAge(Integer age) {
        this.age = age;
    }

    public Employee withAge(Integer age) {
        this.age = age;
        return this;
    }

    @JsonProperty("Sex")
    public String getSex() {
        return sex;
    }

    @JsonProperty("Sex")
    public void setSex(String sex) {
        this.sex = sex;
    }

    public Employee withSex(String sex) {
        this.sex = sex;
        return this;
    }

    @JsonProperty("Address")
    public Address getAddress() {
        return address;
    }

    @JsonProperty("Address")
    public void setAddress(Address address) {
        this.address = address;
    }

    public Employee withAddress(Address address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("employeeId", employeeId).append("firstName", firstName).append("lastName", lastName).append("age", age).append("sex", sex).append("address", address).toString();
    }

}
