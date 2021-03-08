
<a name="paths"></a>
## Paths

<a name="deleteinfousingpost"></a>
### 删除info
```
POST /info/delete
```


#### Description
detail notes


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**id**  <br>*optional*|id|integer (int64)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* 信息tag


<a name="getinfobyidusingpost"></a>
### 获取info
```
POST /info/getUser
```


#### Description
detail notes


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**id**  <br>*optional*|id|integer (int64)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Info](#info)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* 信息tag


<a name="getinfosusingget"></a>
### 获取info
```
GET /info/getUser
```


#### Description
detail notes


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|< [Info](#info) > array|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Produces

* `\*/*`


#### Tags

* 信息tag


<a name="insertinfousingpost"></a>
### 新增info
```
POST /info/insert
```


#### Description
detail notes


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**info**  <br>*required*|info|[Info](#info)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* 信息tag


<a name="updateinfousingpost"></a>
### 更改info
```
POST /info/update
```


#### Description
detail notes


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**info**  <br>*required*|info|[Info](#info)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* 信息tag


<a name="postuserusingpost"></a>
### 新增user
```
POST /user/
```


#### Description
detail notes


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**user**  <br>*required*|user|[User](#user)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* 用户tag


<a name="getusersusingget"></a>
### 获取user
```
GET /user/
```


#### Description
detail notes


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|< [User](#user) > array|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Produces

* `\*/*`


#### Tags

* 用户tag


<a name="getuserbyidusingget"></a>
### 获取user
```
GET /user/{id}
```


#### Description
detail notes


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int64)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[User](#user)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Produces

* `\*/*`


#### Tags

* 用户tag


<a name="putuserbyidusingput"></a>
### 更改user
```
PUT /user/{id}
```


#### Description
detail notes


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|用户编号|integer (int64)|
|**Body**|**user**  <br>*required*|user|[User](#user)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* 用户tag


<a name="deleteuserbyidusingdelete"></a>
### 删除user
```
DELETE /user/{id}
```


#### Description
detail notes


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int64)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


#### Produces

* `\*/*`


#### Tags

* 用户tag



