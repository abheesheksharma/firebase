//Inside AppCompatActivity
FirebaseFirestore db = FirebaseFirestore.getInstance();

//Inside OnCreate or inside another function
DocumentReference dataRef = db.collection("collection_name").document("document_name");
dataRef.update("field_name", "here data for insertion");
