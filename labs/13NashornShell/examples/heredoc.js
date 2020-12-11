#!/usr/bin/jjs -scripting
var fname = "Tom", lname = "McGinn"
var empID = 100, hireDate = "10/1/2000"
print (<<EOS);
Employee Name: ${fname} ${lname}
Employee ID:   ${empID}
Hire Date:     ${hireDate}
EOS
