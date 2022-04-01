package com.example.mokhttp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*
import java.net.ServerSocket
import java.net.Socket

class MainActivity : AppCompatActivity() {

    private var adapter: ConcatAdapter = ConcatAdapter()

    private val itemAdapter = ItemAdapter()
    private val listAdapter = MyListAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mutableListOf = mutableListOf<String>()
        for (i in 0..10) {
            mutableListOf.add("hahahha$i")
        }

        itemAdapter.setData("牛牛")
        listAdapter.setData(mutableListOf)
        adapter.addAdapter(itemAdapter)

        adapter.addAdapter(listAdapter)
        for (i in 0..30) {
            val itemAdapter1 = ItemAdapter()
            itemAdapter1.setData("牛牛$i")
            adapter.addAdapter(itemAdapter1)
        }
        val linearLayoutManager = LinearLayoutManager(this)
        rv.layoutManager = linearLayoutManager
        rv.adapter = adapter


    }

    fun tcpServer() {
        try {
            //创建服务器端 Socket，指定监听端口
            val serverSocket = ServerSocket(8888)
            //等待客户端连接
            val clientSocket: Socket = serverSocket.accept()
            //获取客户端输入流，
            val input: InputStream = clientSocket.getInputStream()
            val isr = InputStreamReader(input)
            val br = BufferedReader(isr)
            var data: String? = null
            //读取客户端数据
            while (br.readLine().also { data = it } != null) {
                println("服务器接收到客户端的数据：$data")
            }
            //关闭输入流
            clientSocket.shutdownInput()
            //获取客户端输出流
            val os: OutputStream = clientSocket.getOutputStream()
            val pw = PrintWriter(os)
            //向客户端发送数据
            pw.print("服务器给客户端回应的数据")
            pw.flush()
            //关闭输出流
            clientSocket.shutdownOutput()
            //关闭资源
            pw.checkError()
            os.close()
            br.close()
            isr.close()
            input.close()
            clientSocket.close()
            serverSocket.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}