package org.machinecoding.models;

import java.util.Objects;

public class UserPair {
   private User user;
   private User friend;

   public User getUser() {
      return user;
   }

   public User getFriend() {
      return friend;
   }

   public UserPair(User user, User friend) {
      this.user = user;
      this.friend = friend;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      UserPair userPair = (UserPair) o;
      return Objects.equals(user, userPair.user) &&
              Objects.equals(friend, userPair.friend);
   }

   @Override
   public int hashCode() {
      return Objects.hash(user, friend);
   }
}
