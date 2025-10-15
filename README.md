# Outline
# MainActictivity.java

1. Add saved instance state code from slides (line 38)
2. add private static final String BUTTON_STATE = "BUTTON_STATE_KEY"; on line 21 (replace the TODO)
3. override (ctrl+o) onSaveInstanceState on line 84
    1. protected void onSaveInstanceState(@NonNull Bundle outState) {...};
4. create getMessage() on line 64
    1. move the code from the onClick to the method.
5. Run it.
    1. why is it still broken?
6. fix the todo on line 43
7. add a long click listener on line 53
    1. button.SetOnL AND PRESS TAB
    2. new View.O and press tab.
    3. Intent intent = ChildActivity.intentFactory(getApplicationContext(),messageOne);
8. Create a child activity

# activity_child.xml
1. add a textView
2. add a button
    1. MAKE NOTE OF THE ID


# ChildActivity

1. remove the EdgeToEdge code
2. remove the ViewCompat code
3. create an ActivityChildBinding object
4. binding = ActivityChildBinding.inflate(getLayoutInflator);
   setContentView(binding.)
5. declare a boolean showMessage1Child somewhere near the top of the class (similar to messageOne in MainActivity)
6. Declare a SHOW_MESSAGE_ONE constant in ChildActivity,  similar to the BUTTON_STATE variable in MainActivity
7. Use SHOW_MESSAGE_ONE in the intentFactory method in the ChildActivity when adding a boolean extra
8. Use SHOW_MESSAGE_ONE to RETRIEVE the boolean extra and store the returned value in showMessage1Child
    1. getIntent().getBooleanExtra(...)
9. Use the value stored in showMessage1Child to set the text that is displayed on the button
    1. binding.childActivityButton.setText(showMessage1Child ? "TRUE!" : "FALSE!");
10. create an intent factory in ChildActivity
11. TEST IT
12. add an onLongClickListener to the button on the child activity
13. Use the intent factory from MainActivty to switch from child activity to MainActivity
14. update MainActivity to use the extra.

