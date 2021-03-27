
package com.joy.kafka.json.schema;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "AadharCard",
    "PanCard"
})
public class GovernmentEmployee
    extends Employee
{

    @JsonProperty("AadharCard")
    private String aadharCard;
    @JsonProperty("PanCard")
    private String panCard;

    @JsonProperty("AadharCard")
    public String getAadharCard() {
        return aadharCard;
    }

    @JsonProperty("AadharCard")
    public void setAadharCard(String aadharCard) {
        this.aadharCard = aadharCard;
    }

    public GovernmentEmployee withAadharCard(String aadharCard) {
        this.aadharCard = aadharCard;
        return this;
    }

    @JsonProperty("PanCard")
    public String getPanCard() {
        return panCard;
    }

    @JsonProperty("PanCard")
    public void setPanCard(String panCard) {
        this.panCard = panCard;
    }

    public GovernmentEmployee withPanCard(String panCard) {
        this.panCard = panCard;
        return this;
    }

    @Override
    public GovernmentEmployee withEmployeeId(String employeeId) {
        super.withEmployeeId(employeeId);
        return this;
    }

    @Override
    public GovernmentEmployee withFirstName(String firstName) {
        super.withFirstName(firstName);
        return this;
    }

    @Override
    public GovernmentEmployee withLastName(String lastName) {
        super.withLastName(lastName);
        return this;
    }

    @Override
    public GovernmentEmployee withAge(Integer age) {
        super.withAge(age);
        return this;
    }

    @Override
    public GovernmentEmployee withSex(String sex) {
        super.withSex(sex);
        return this;
    }

    @Override
    public GovernmentEmployee withAddress(Address address) {
        super.withAddress(address);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString()).append("aadharCard", aadharCard).append("panCard", panCard).toString();
    }

}
