-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 22 Bulan Mei 2023 pada 14.15
-- Versi server: 10.4.21-MariaDB
-- Versi PHP: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pethotel_db`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengaturan`
--

CREATE TABLE `pengaturan` (
  `sisa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pengaturan`
--

INSERT INTO `pengaturan` (`sisa`) VALUES
(10);

-- --------------------------------------------------------

--
-- Struktur dari tabel `riwayat`
--

CREATE TABLE `riwayat` (
  `id` int(11) NOT NULL,
  `nama_pemilik` varchar(20) NOT NULL,
  `jenis_hewan` varchar(10) NOT NULL,
  `harga` bigint(20) NOT NULL DEFAULT 0,
  `waktu_masuk` datetime NOT NULL,
  `waktu_keluar` datetime DEFAULT NULL,
  `user_id` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `riwayat`
--

INSERT INTO `riwayat` (`id`, `nama_pemilik`, `jenis_hewan`, `harga`, `waktu_masuk`, `waktu_keluar`, `user_id`) VALUES
(1, 'Timot', 'anjing', 40000, '2023-05-22 18:23:43', '2023-05-22 18:24:17', 'sanibedul'),
(2, 'Dimas', 'Kucing', 50000, '2023-05-22 18:39:43', '2023-05-22 19:04:49', 'sanibedul'),
(3, 'Dimas', 'Kucing', 50000, '2023-05-22 18:40:26', '2023-05-22 19:05:15', 'sanibedul'),
(4, 'Nugraha', 'Anjing', 40000, '2023-05-22 18:41:02', '2023-05-22 18:41:09', 'satyaarya'),
(5, 'Babu', 'Kucing', 50000, '2023-05-22 18:49:40', '2023-05-22 18:49:47', 'sanibedul'),
(6, 'Wanto', 'Kucing', 50000, '2023-05-22 18:57:54', '2023-05-22 19:05:41', 'sanibedul');

-- --------------------------------------------------------

--
-- Struktur dari tabel `users`
--

CREATE TABLE `users` (
  `username` varchar(20) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `users`
--

INSERT INTO `users` (`username`, `password`, `role`) VALUES
('dimasisya', 'dimasganteng', 'admin'),
('sanibedul', 'sani123', 'employee'),
('satyaarya', 'satya123', 'employee');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `riwayat`
--
ALTER TABLE `riwayat`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `riwayat`
--
ALTER TABLE `riwayat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
