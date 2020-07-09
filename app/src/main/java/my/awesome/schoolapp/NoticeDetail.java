package my.awesome.schoolapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//import com.example.schoolapp.R;

public class NoticeDetail extends AppCompatActivity {
    TextView subject,notice;
    Button Pdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_detail);

        subject=findViewById(R.id.Subject_detail);
        notice=findViewById(R.id.Notice_detail);
        Pdf=findViewById(R.id.pdf);

        Intent intent=getIntent();
        final String Sub=intent.getExtras().getString("Subject");
        String Not=intent.getExtras().getString("Notice");

        subject.setText(Sub);
        notice.setText(Not);

        Pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // createPDF();


            }
        });

      /*  public void createPDF()
        {
            Document doc = new Document();

            try {
                String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/PDF";

                File dir = new File(path);
                if(!dir.exists())
                    dir.mkdirs();

                //Log.d("PDFCreator", "PDF Path: " + path);

                File file = new File(dir, "demo.pdf");
                FileOutputStream fOut = new FileOutputStream(file);

                PdfWriter.getInstance(doc, fOut);

                //open the document
                doc.open();*/

                /* Create Paragraph and S`enter code here`et Font */
               // Paragraph p1 = new Paragraph("Hi! I am Generating my first PDF using DroidText");

                /* Create Set Font and its Size */
                /*Font paraFont= new Font(Font.HELVETICA);
                paraFont.setSize(16);
                p1.setAlignment(Paragraph.ALIGN_CENTER);
                p1.setFont(paraFont);

                //add paragraph to document
                doc.add(p1);


                Paragraph p2 = new Paragraph("This is an awesome of a simple paragraph");*/

                /* You can also SET FONT and SIZE like this */
               /* Font paraFont2= new Font(Font.COURIER,14.0f, Color.GREEN);
                p2.setAlignment(Paragraph.ALIGN_CENTER);
                p2.setFont(paraFont2);

                doc.add(p2);*/

                /* Inserting Image in PDF */
            /*ByteArrayOutputStream stream = new ByteArrayOutputStream();
            Bitmap bitmap = BitmapFactory.decodeResource(getBaseContext().getResources(), R.drawable.android);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100 , stream);
            Image myImg = Image.getInstance(stream.toByteArray());
            myImg.setAlignment(Image.MIDDLE);

            //add image to document
            doc.add(myImg);*/

                //set footer
              /*  Phrase footerText = new Phrase("This is an awesome of a footer");
                HeaderFooter pdfFooter = new HeaderFooter(footerText, false);
                doc.setFooter(pdfFooter);

                Toast.makeText(getApplicationContext(), "Created...", Toast.LENGTH_LONG).show();

            } catch (DocumentException de) {
                Log.e("PDFCreator", "DocumentException:" + de);
            } catch (IOException e) {
                Log.e("PDFCreator", "ioException:" + e);
            }
            finally
            {
                doc.close();
            }
        }*/



    }
}
