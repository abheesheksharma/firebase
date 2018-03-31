//Inside AppCompatActivity
FirebaseFirestore db = FirebaseFirestore.getInstance();

//Inside OnCreate or inside another function
DocumentReference docRef = db.collection("collection_name").document("document_name");
docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();

                        String name = document.getString("field_name");
                        personametext.setText( name );
                    } else {
                        Toast.makeText( MyAccount.this, "There is error", Toast.LENGTH_SHORT ).show();
                    }
                }
            });
