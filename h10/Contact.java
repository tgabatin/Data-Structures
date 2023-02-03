package edu.ics211.h10;

/**
 * Represents a Contact.
 *
 * @author Cam Moore
 *
 */
public class Contact {
  private String firstName;
  private String lastName;
  private String contactPhoneNumber;

  /**
   * Creates a new Contact with the given information.
   *
   * @param first a String, the first name.
   * @param last a String, the last name.
   * @param contact a String, the contact phone number.
   */
  public Contact(String first, String last, String contact) {
    this.firstName = first;
    this.lastName = last;
    this.contactPhoneNumber = contact;
  }


  /**
   * Returns the firstName of this Contact.
   *
   * @return the firstName of this Contact.
   */
  public final String getFirstName() {
    return firstName;
  }


  /**
   * Sets the firstName value of this Contact.
   *
   * @param firstName the firstName to set.
   */
  public final void setFirstName(String firstName) {
    this.firstName = firstName;
  }


  /**
   * Returns the lastName of this Contact.
   *
   * @return the lastName of this Contact.
   */
  public final String getLastName() {
    return lastName;
  }


  /**
   * Sets the lastName value of this Contact.
   *
   * @param lastName the lastName to set.
   */
  public final void setLastName(String lastName) {
    this.lastName = lastName;
  }


  /**
   * Returns the contactPhoneNumber of this Contact.
   *
   * @return the contactPhoneNumber of this Contact.
   */
  public final String getContactPhoneNumber() {
    return contactPhoneNumber;
  }


  /**
   * Sets the contactPhoneNumber value of this Contact.
   *
   * @param contactPhoneNumber the contactPhoneNumber to set.
   */
  public final void setContactPhoneNumber(String contactPhoneNumber) {
    this.contactPhoneNumber = contactPhoneNumber;
  }


  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "Contact [firstName=" + firstName + ", lastName=" + lastName + ", contactPhoneNumber=" + contactPhoneNumber
        + "]";
  }


  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((contactPhoneNumber == null) ? 0 : contactPhoneNumber.hashCode());
    result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
    result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
    return result;
  }


  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof Contact)) {
      return false;
    }
    Contact other = (Contact) obj;
    if (contactPhoneNumber == null) {
      if (other.contactPhoneNumber != null) {
        return false;
      }
    } else if (!contactPhoneNumber.equals(other.contactPhoneNumber)) {
      return false;
    }
    if (firstName == null) {
      if (other.firstName != null) {
        return false;
      }
    } else if (!firstName.equals(other.firstName)) {
      return false;
    }
    if (lastName == null) {
      if (other.lastName != null) {
        return false;
      }
    } else if (!lastName.equals(other.lastName)) {
      return false;
    }
    return true;
  }

}
