import mysql.connector as connector
import mysql
from mysql.connector import Error
import pandas as pd
import numpy as np
import time
from pandas import DataFrame
import matplotlib.pyplot as plt
from sklearn.cluster import DBSCAN
from sklearn.preprocessing import StandardScaler



while(True):
    time.sleep(300)
    try:
        connection = mysql.connector.connect(host='localhost',
                                            database='demo',
                                            user='root',
                                            password='aps123',
                                            auth_plugin='mysql_native_password')
        thresh = -99
        dataList = list()
        data = pd.DataFrame() 
        SQL_Query = pd.read_sql_query(
    '''select distinct machine_id from mem_data''', connection)
        machines = pd.DataFrame(SQL_Query)
        print(machines)
        cursor = connection.cursor()
        for x in range(0,machines.size):
            SQL_Query = "select active_col, occurance from mem_data where machine_id = %s order by occurance desc limit 35"
            cursor.execute(SQL_Query,(machines.iloc[x,0],))
            data = DataFrame(cursor.fetchall())
            dataList.append(data)
        
        for x in range(dataList.__len__()):
            
            xcol = dataList[x][1]
            dbScanData = dataList[x][0]
            data = dbScanData
            dbScanData = dbScanData.values.astype('float', copy = True)
            dbScanData = dbScanData.reshape(-1,1)
            dbScanDataScalar = StandardScaler().fit(dbScanData)
            dbScanData = dbScanDataScalar.transform(dbScanData)
            X = np.array(dbScanData)
            

            model = DBSCAN(eps = 0.25, min_samples = 4).fit(X)
            outliers = data[model.labels_ == -1]
            clusters = data[model.labels_ != -1]
            colors = model.labels_
            colors_clusters = colors[colors != -1]
            colors_outliers = 'red'
            xcol_outlier = xcol
            indexes = []
            indexes = xcol
            xcol = xcol.loc[clusters.index]
            xcol_outlier = xcol_outlier.loc[outliers.index]
            fig = plt.figure()
            ax = fig.add_axes([.1,.1,1,1])


            '''
            ax.scatter( xcol, clusters.sort_values(), c = colors_clusters, edgecolors = 'black', s = 50)

            ax.scatter( xcol_outlier, outliers.sort_values(),  c = colors_outliers, edgecolors = 'black', s = 50)

            plt.show()'''
            
            #updation of anomalies in db tables
            for x in range(len(indexes)):
                cursor.execute("""UPDATE mem_data SET anomaly =%d WHERE occurance= %d""" % (int(model.labels_[x]),int(indexes.loc[x])))
                connection.commit()


    except Error as e:
        print("Error while connecting to MySQL", e)
    finally:
        if connection.is_connected():
            #cursor.close()
            connection.close()
            print("MySQL connection is closed")
        






