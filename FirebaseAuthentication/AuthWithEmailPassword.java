//inside class
public FirebaseAuth mAuth;
public FirebaseAuth.AuthStateListener mAuthListner;

//inside onCreate functon
mAuth = FirebaseAuth.getInstance();
FirebaseUser currentUser = mAuth.getCurrentUser(); // Check if user is signed in (non-null) and update UI accordingly.

String email = login_em.getText().toString().trim();
                String password = login_psd.getText().toString().trim();
                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Toast.makeText( MainActivity.this, "Successfully Logged in", Toast.LENGTH_LONG ).show();
                            mProgress.dismiss();
                            Intent myaccount = new Intent( MainActivity.this,MarkAttendence.class );

                            //This is for not go back again in login
                            myaccount.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            myaccount.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity( myaccount );
                            finish();
                        }
                        else{
                            Toast.makeText( MainActivity.this, "Email Id or Password is Incorrect", Toast.LENGTH_LONG ).show();
                            mProgress.dismiss();
                        }



                    }
                });
                
                
          
// This is check for user is already loggedin or not
mAuthListner = new FirebaseAuth.AuthStateListener() {
                    @Override
                    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                        if(firebaseAuth.getCurrentUser() != null){
                            Toast.makeText(MainActivity.this,"Welcome Back",Toast.LENGTH_LONG).show();
                            Intent page = new Intent( MainActivity.this, MarkAttendence.class );
                            startActivity( page );
                            finish();
                        }
                        else{
                            Toast.makeText(MainActivity.this,"Please Login",Toast.LENGTH_LONG).show();
                        }

                    }
                };
                
// Place outside the onCreate function
@Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListner);
    }
