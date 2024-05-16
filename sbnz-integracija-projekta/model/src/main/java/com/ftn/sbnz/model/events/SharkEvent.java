package com.ftn.sbnz.model.events;

import java.io.Serializable;
import java.util.Date;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

@Role(Role.Type.EVENT)
@Timestamp("executionTime")
@Expires("1h")
public class SharkEvent implements Serializable {

    private static final long serialVersionUID = 1L;
    private Date executionTime;
    private Long sharkId;

    public SharkEvent() {
        super();
    }
    
    public SharkEvent(Long sharkId) {
        super();
        this.executionTime = new Date();
        this.sharkId = sharkId;
    }

    public Date getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Date executionTime) {
        this.executionTime = executionTime;
    }

    public Long getSharkId() {
        return sharkId;
    }

    public void setSharkId(Long customerId) {
        this.sharkId = customerId;
    }

}

