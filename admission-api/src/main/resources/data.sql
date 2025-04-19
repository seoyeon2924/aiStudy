INSERT INTO applicants (exam_id, name, birth_date, department, admission_type, phone_number, email, status, created_at) 
VALUES 
('2024001', '홍길동', '2000-01-01', '컴퓨터공학과', '수시전형', '010-1234-5678', 'hong@example.com', 'PENDING', CURRENT_TIMESTAMP),
('2024002', '김철수', '2000-02-15', '전자공학과', '정시전형', '010-2345-6789', 'kim@example.com', 'PENDING', CURRENT_TIMESTAMP),
('2024003', '이영희', '2000-03-20', '컴퓨터공학과', '수시전형', '010-3456-7890', 'lee@example.com', 'APPROVED', CURRENT_TIMESTAMP),
('2024004', '박지민', '2000-04-10', '기계공학과', '정시전형', '010-4567-8901', 'park@example.com', 'PENDING', CURRENT_TIMESTAMP),
('2024005', '최유나', '2000-05-05', '전자공학과', '수시전형', '010-5678-9012', 'choi@example.com', 'REJECTED', CURRENT_TIMESTAMP);
