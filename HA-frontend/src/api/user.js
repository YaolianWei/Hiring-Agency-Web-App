import request from '@/utils/request'

export function login(params) {
  return request({
    url: '/login',
    method: 'get',
    params
  })
}

// 列出所有的问题
export function allQuestions(data) {
  return request({
    url: '/question',
    method: 'post',
    data
  })
}

// 提交问题
export function submitQuestions(params) {
  return request({
    url: '/setQuestions?'+"question="+params.Question+"&answer="+params.Answer+"&userId="+params.UserID,
    method: 'get'
    // params
  })
}

// 之后登录 回答问题
export function answerQuestions(params) {
  return request({
    url: '/getQuestions',
    method: 'get',
    params
  })
}

// admin登录后 添加staff
export function addStaff(params) {
  return request({
    url: '/addStaff',
    method: 'get',
    params
  })
}

// admin table数据
export function staffList(params) {
  return request({
    url: '/staffList',
    method: 'get',
    params
  })
}

export function getInfo(params) {
  return request({
    url: '/getUserInfo',
    method: 'get',
    params
  })
}

export function logout() {
  return request({
    url: '/vue-admin-template/user/logout',
    method: 'post'
  })
}
