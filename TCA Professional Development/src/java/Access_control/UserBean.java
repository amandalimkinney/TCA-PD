
package Access_control;

public class UserBean {
	
      private String username;
      private String password;
      private String accountID;
      public boolean valid;
	
	
      public String getaccountID() {
         return accountID;
	}

      public void setaccountID(String newAccountID) {
         accountID = newAccountID;
      }		

      public String getPassword() {
         return password;
	}

      public void setPassword(String newPassword) {
         password = newPassword;
	}
	
			
      public String getUsername() {
         return username;
			}

      public void setUserName(String newUsername) {
         username = newUsername;
			}

				
      public boolean isValid() {
         return valid;
	}

      public void setValid(boolean newValid) {
         valid = newValid;
	}	
}
    
    