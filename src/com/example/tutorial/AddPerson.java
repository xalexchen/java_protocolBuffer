package com.example.tutorial;

import java.io.FileOutputStream;

import com.example.tutorial.AddressBookProtos.AddressBook;
import com.example.tutorial.AddressBookProtos.Person;

class AddPerson {
  public static void main(String[] args) throws Exception {
    AddressBook.Builder addressBook = AddressBook.newBuilder();
    Person.Builder person = Person.newBuilder();
    person.setId(Integer.valueOf(12));
    person.setName("xalexchen");
//    person.setEmail("alex@mircale.com");
    
    Person.PhoneNumber.Builder phoneNumber = Person.PhoneNumber.newBuilder();
    phoneNumber.setNumber("10086");
    phoneNumber.setType(Person.PhoneType.MOBILE);
    person.addPhone(phoneNumber);
    
    // Add an address.
    addressBook.addPerson(person.build());
    
    // Write the new address book back to disk.
    FileOutputStream output = new FileOutputStream("output");
    try {
      addressBook.build().writeTo(output);
    } finally {
      output.close();
    }
  }
}
