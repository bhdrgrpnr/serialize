Find a meaningful way to make possible to penetrate a field value of Java serialized object by using only JRE provided libraries.

Solution class has a method "penetrate" that needs to be filled with penetration logic.
This method has 3 arguments:
 - base64ObjectInput = Java serialized object in Base64 string format. Hold the object that needs to be penetrated.
 - fieldName = Field name in the object that needs to be penetrated.
 - newValue = A new value to be assigned for the field defined by "fieldName" argument.
 
 The output shall also have Base64 string format.
 
 The solution must pass 3 tests defined in com.nortal.testassignment.SolutionTest class.