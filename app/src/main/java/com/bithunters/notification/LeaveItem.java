package com.bithunters.notification;

/**
 * Created by DELL on 1/29/2018.
 * All Rights Reserved by MLPJ©
 */

public class LeaveItem {

    private String LeaveStartDate;
    private String AcceptReject;

    public LeaveItem(String leaveStartDate, String acceptReject) {
        LeaveStartDate = leaveStartDate;
        AcceptReject = acceptReject;
    }

    public String getLeaveStartDate() {
        return LeaveStartDate;
    }

    public String getAcceptReject() {
        return AcceptReject;
    }
}
