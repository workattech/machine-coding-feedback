package org.main;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Group {
    private String groupName;
    private GroupUsers groupUsers;
    private Balances balances;

    public Group(String groupName, GroupUsers groupUsers, Balances balances) {
        this.groupName = groupName;
        this.groupUsers = groupUsers;
        this.balances = balances;
    }
}
