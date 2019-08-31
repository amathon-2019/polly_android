package com.example.awspolly.data

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast
class DBHandler(
    context: Context,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    companion object {
        private val DATABASE_NAME = "MyData.db"
        private val DATABASE_VERSION = 1

        val FILES_TABLE_NAME = "pollyTable"
        val COLUMN_POLLYID = "pollyId"
        val COLUMN_POLLYDATE  = "pollyDate"
        val COLUMN_POLLYFLIE = "pollyFile"
    }


    @SuppressLint("SQLiteString")
    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_POLLYS_TABLE = ("CREATE TABLE $FILES_TABLE_NAME (" +
                "$COLUMN_POLLYID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$COLUMN_POLLYDATE DATE," +
                "$COLUMN_POLLYFLIE STRING DEFAULT 0)")
        db?.execSQL(CREATE_POLLYS_TABLE)
    }

    fun addPolly(mCtx: Context, item: PollyItem){
        val values = ContentValues()
        values.put(COLUMN_POLLYID,item.pollyId)
        values.put(COLUMN_POLLYDATE,item.pollyDate)
        values.put(COLUMN_POLLYFLIE,item.pollyFile)
        val db = this.writableDatabase
        try {
            db.insert(COLUMN_POLLYID,null,values)
            Toast.makeText(mCtx,"add polly id",Toast.LENGTH_LONG).show()
        }catch (e: Exception) {
            Toast.makeText(mCtx,e.message,Toast.LENGTH_SHORT).show()
        }
        db.close()
    }

    fun getCustomers(mCtx: Context): ArrayList<PollyItem> {
        val qry = "Select * From $FILES_TABLE_NAME"
        val db = this.readableDatabase
        val cursor = db.rawQuery(qry, null)
        val pollyItemList = ArrayList<PollyItem>()

        // DB에 저장된 데이터를 가져와 Customer() 데이터 클래스에 저장한다.
        if (cursor.count == 0)
            Toast.makeText(mCtx, "No Records Found", Toast.LENGTH_SHORT).show()
        else {
            cursor.moveToFirst()
            while (!cursor.isAfterLast) {
                val pollyItem = PollyItem()
                pollyItem.pollyId = cursor.getString(cursor.getColumnIndex(COLUMN_POLLYID))
                pollyItem.pollyDate = cursor.getString(cursor.getColumnIndex(COLUMN_POLLYDATE))
                pollyItem.pollyFile = cursor.getString(cursor.getColumnIndex(COLUMN_POLLYFLIE))
                pollyItemList.add(pollyItem)
                cursor.moveToNext()
            }
            Toast.makeText(mCtx, "${cursor.count} Records Found", Toast.LENGTH_SHORT).show()
        }
        cursor.close()
        db.close()
        return pollyItemList
    }

    //칼럼에 있는 ID값과 DB의 id값이 같다면 DB의 데이터를 삭제한다.
    fun deletePolly(pollyId: Int): Boolean {
        val qry = "Delete From $FILES_TABLE_NAME where $COLUMN_POLLYID = $pollyId"
        val db = this.writableDatabase
        var result =false
        try {
            val cursor = db.execSQL(qry)
            result = true
        } catch (e : Exception){
            Log.e(ContentValues.TAG, "Error Deleting")
        }
        db.close()
        return result
    }

    fun updateCustomer(id: String, customerName : String, maxCredit : String, phoneNumber : String) : Boolean{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        var result = false
        contentValues.put(COLUMN_POLLYID, customerName)
        contentValues.put(COLUMN_POLLYDATE,maxCredit.toDouble())
        contentValues.put(COLUMN_POLLYFLIE,phoneNumber)
        try {
            db.update(FILES_TABLE_NAME,contentValues,"$COLUMN_POLLYID = ?",arrayOf(id))
            result = true
        }catch (e:Exception){
            Log.e(ContentValues.TAG, "Error Updating")
            result = false
        }
        return result
    }
}