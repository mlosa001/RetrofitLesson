package android.example.com.retrofit.Model;



    public class RandoPuppy {
        private String status;
        private String message;

        public String getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }
    }

    //where does this go?

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://dog.ceo/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();