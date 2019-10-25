package nandaadi.saputra.uts;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.edt_ktp)
    EditText edtKtp;
    @BindView(R.id.edt_nama)
    EditText edtNama;
    @BindView(R.id.edt_nohp)
    EditText edtNohp;
    @BindView(R.id.edt_asal)
    EditText edtAsal;
    @BindView(R.id.edt_tujuan)
    EditText edtTujuan;
    @BindView(R.id.edt_harga)
    EditText edtHarga;
    @BindView(R.id.edt_jumlahpesan)
    EditText edtJumlahpesan;
    @BindView(R.id.edt_bayar)
    EditText edtBayar;
    @BindView(R.id.btn_total)
    Button btnTotal;
    @BindView(R.id.tv_total)
    TextView tvTotal;
    @BindView(R.id.tv_uangkembalian)
    TextView tvUangkembalian;
    @BindView(R.id.tv_keterangan)
    TextView tvKeterangan;
    @BindView(R.id.btn_hapus)
    Button btnHapus;
    @BindView(R.id.btn_keluar)
    Button btnKeluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle("Pemesanan Tiket Kereta Api");

        //memberikan action pada tombol proses

        btnTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String noktp = edtKtp.getText().toString().trim();
                String nama = edtNama.getText().toString().trim();
                String nohp = edtNohp.getText().toString().trim();
                String asal = edtAsal.getText().toString().trim();
                String tujuan = edtTujuan.getText().toString().trim();
                String harga = edtHarga.getText().toString().trim();
                String kembalian = tvUangkembalian.getText().toString().trim();
                String bayar = edtBayar.getText().toString().trim();
                String jumlahpesan = edtJumlahpesan.getText().toString().trim();
                String totalharga = tvTotal.getText().toString().trim();

                double jumlahpesantiket = Double.parseDouble(jumlahpesan);
                double hargatiket = Double.parseDouble(harga);
                double uangbayar = Double.parseDouble(bayar);
                double total = (jumlahpesantiket * hargatiket);
                tvTotal.setText("Total Belanja : " + total);

                //pemberian if dan else untuk aturan pemberian harga

                if (total >= 100000) {
                    edtHarga.setText("Harga : Kelas Ekonomi");
                } else if (total >= 200000) {
                    edtHarga.setText("Harga : Kelas Bisnis");
                } else if (total >= 500000) {
                    edtHarga.setText("Harga : Kelas Eksekutif");
                } else {
                    edtHarga.setText("Tidak Menginput/ Salah Input");
                }
                double uangkembalian = (uangbayar - total);

                if (uangbayar < total) {
                    tvKeterangan.setText("Keterangan : uang bayar kurang Rp " + (-uangkembalian));
                    tvUangkembalian.setText("Uang Kembali : Rp 0");
                } else {
                    tvKeterangan.setText("Keterangan : Tunggu Kembalian");
                    tvUangkembalian.setText("Uang Kembali : " + uangkembalian);
                }


                //memberikan action pada tombol reset data
            }
        });
        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtKtp.setText(" ");
                edtNama.setText(" ");
                tvTotal.setText(" Total Belanja : Rp 0");
                edtHarga.setText(" ");
                edtBayar.setText(" ");
                tvUangkembalian.setText("Uang Kembali : Rp 0");
                edtJumlahpesan.setText(" ");
                tvKeterangan.setText("Keterangan : - ");

                Toast.makeText(getApplicationContext(), "Data sudah direset", Toast.LENGTH_LONG).show();

                // memberikan action pada tombol keluar
            }
        });
        btnKeluar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                moveTaskToBack(true);
            }
        });
    }
}