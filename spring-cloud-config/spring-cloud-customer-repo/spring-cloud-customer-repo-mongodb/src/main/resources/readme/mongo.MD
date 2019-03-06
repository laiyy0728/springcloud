# 在 mongo 中新建一个 database，名称为 springcloud

# 在 springcloud 中依次执行下列语句

## 创建一个数据集
db.createCollection('springcloud')

## 获取数据集内容
db.getCollection('springcloud').find({})

## 添加一条数据集内容
db.springcloud.insert({
  "label" : "master",
  "profile" : "prod",
  "source" : {
    "com" : {
      "laiyy" : {
        "gitee" : {
          "config" : "I am the mongdb configuration file from dev environment. I will edit."
        }
      }
    }
  }
})

## 再次查询数据集内容
db.getCollection('springcloud').find({})