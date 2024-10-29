import { Card, CardContent, TextField, Typography } from "@mui/material";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

interface UserInfo {
  email: string; // 사용자 이메일
  password: string; // 사용자 비밀번호
  confirmPassword: string; // 비밀번호 확인 필드(비밀번호와 일치해야 함)
}

interface Errors {
  email?: string;
  password?: string;
  confirmPassword?: string;
  form?: string; // 전체 폼 오류 메시지 (EX: 서버 오류 등)
}

export default function SignUp() {
  // userInfo: 사용자가 입력한 회원가입 정보를 관리
  const [userInfo, setUserInfo] = useState<UserInfo>({
    email: "",
    password: "",
    confirmPassword: "",
  });

  // errors: 유효성 검사 오류 메시지를 관리(저장)
  const [errors, setErrors] = useState<Errors>({});

  // useNavigate() 훅: 페이지 전환 기능을 사용
  const navigate = useNavigate();

  //! == 이벤트 핸들러 ==
  // 입력 필드 변경 이벤트 핸들러
  const handleInputChange = () => {};

  return (
    <Card
      variant="outlined"
      sx={{
        width: 360,
        m: "auto",
        mt: 4,
      }}
    >
      <CardContent>
        {/* 회원가입 제목 표시 */}
        <Typography variant="h5" mb={2}>
          회원가입
        </Typography>
        {/* 입력 필드 */}
        <TextField
          label="이메일"
          type="email"
          name="email"
          variant="outlined"
          value={userInfo.email}
          onChange={handleInputChange}
          fullWidth // 전체 너비 차지
          margin="normal"
          // !! 데이터값
          // : 값을 boolean 타입으로 변환하는 방식
          // - 값이 존재하면 true
          // - 값이 존재하지 않으면 false
          error={!!errors.email}
          helperText={errors.email}
        />
        <TextField
          label="비밀번호"
          type="password"
          name="password"
          variant="outlined"
          value={userInfo.password}
          onChange={handleInputChange}
          fullWidth
          margin="normal"
          error={!!errors.password}
          helperText={errors.password}
        />
        <TextField
          label="비밀번호 확인"
          type="password"
          name="confirmPassword"
          variant="outlined"
          value={userInfo.confirmPassword}
          onChange={handleInputChange}
          fullWidth 
          margin="normal"
          error={!!errors.confirmPassword} // true면 textfield가 빨간색
          helperText={errors.confirmPassword} // error 메시지 출력 
        />

        {/* 전체 폼 오류 메시지가 있을 경우 표시 */}
        {/* errors.form이 있으면 errors.form을 출력 */}
        {errors.form && (
          <Typography color="error" mt={2}>
            {errors.form}
          </Typography>
        )}
      </CardContent>
    </Card>
  );
}
